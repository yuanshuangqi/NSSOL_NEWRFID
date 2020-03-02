package com.nssol.controller;

import static com.nssol.common.Constant.PACK_BAK;
import static com.nssol.common.Constant.PO_IMPORT;

import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.util.Base64;
import com.nssol.config.RabbitMQSendConfig;
import com.nssol.controller.response.MessageResponse;
import com.nssol.model.PlanningData;
import com.nssol.service.BatchService;
import com.nssol.task.BatchTask;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about Batch Info" })
public class BatchController {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    private BatchService batchService;

    /**
     * 在ScheduledFuture中有一个cancel可以停止定时任务。
     */
    private ScheduledFuture<?> poImportFuture;
    private ScheduledFuture<?> packBakFuture;
    @Autowired
    private BatchTask batchTask;
    
    /**
     * ThreadPoolTaskScheduler：线程池任务调度类，能够开启线程池进行任务调度。
     * ThreadPoolTaskScheduler.schedule()方法会创建一个定时计划ScheduledFuture，在这个方法需要添加两个参数，Runnable（线程接口类） 和CronTrigger（定时任务触发器）
     * @return
     */
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @ApiOperation(value = "设置PoBatch", notes = "设置PoBatch", produces = "application/json")
    @RequestMapping(value = "/setPoImport", method = RequestMethod.POST)
    public void setPoImport(@RequestParam("cron") String cron) {
        batchService.setBasicInfo(PO_IMPORT, cron);
        if (poImportFuture != null) {
            poImportFuture.cancel(true);
            System.out.println("poImport已停止");
        }
        if (!cron.isEmpty() && cron != null) {
            poImportFuture = threadPoolTaskScheduler.schedule(new BatchRunner(PO_IMPORT), new CronTrigger(cron));
            System.out.println("poImport已启用");
        }
    }

//    @ApiOperation(value = "同步计划任务", notes = "同步计划任务", produces = "application/json")
//    @RequestMapping(value = "/setplanningdata", method = RequestMethod.POST)
    @ApiOperation(value = "同步计划任务", notes = "计划任务", produces = "application/json")
    @RequestMapping(value = "/setplanningdata", method = RequestMethod.POST)
    public String setplanningdata(@RequestBody PlanningData planningData) {
    	MessageResponse messageResponse = new MessageResponse();
    	try {
	        if (planningData != null) {
	        	System.out.println("计划任务开始同步");
	        	messageResponse = batchService.insertPlanningData(planningData);
	        	if(messageResponse.getCode().equals("SIN001") || messageResponse.getCode().equals("SUP001") ||
	        			messageResponse.getCode().equals("SDE001")) {
	        		
	        		RabbitMQSendConfig.sendMQ();
	        	}
	            System.out.println("计划任务结束同步");
	        }
	        else {
	        	messageResponse.setCode("E001");
	        	messageResponse.setMessage("planning is null");
	        	//messageResponse.setMessage("当前计划任务为空");
	        }
    	} catch (Exception ex) {
            ex.printStackTrace();
            messageResponse.setCode("E002");
            messageResponse.setMessage("planning is fail");
        	//messageResponse.setMessage("计划任务同步失败");
        }
    	String retStr="{ \"code\": \""+messageResponse.getCode() +"\", \"message\": \""+messageResponse.getMessage()+"\" }";
    	return retStr;
		
    }
    
    @ApiOperation(value = "设置备份PkBak", notes = "设置备份PkBak", produces = "application/json")
    @RequestMapping(value = "/setPackBak", method = RequestMethod.POST)
    public void setPackBak(@RequestParam("cron") String cron) {
        batchService.setBasicInfo(PACK_BAK, cron);
        if (packBakFuture != null) {
        	packBakFuture.cancel(true);
            System.out.println("packBak已停止");
        }
        if (!cron.isEmpty() && cron != null) {
        	packBakFuture = threadPoolTaskScheduler.schedule(new BatchRunner(PACK_BAK), new CronTrigger(cron));
            System.out.println("packBak已启用");
        }
    }

    /**
     * 创建一个线程，给定时任务调用
     */
    public class BatchRunner implements Runnable {
        private String batchName;

        public BatchRunner(String batchName) {
            this.batchName = batchName;
        }

        public void run() {
            switch (this.batchName) {
                case PO_IMPORT:
                    batchTask.poImport();
                    break;
                case PACK_BAK:
                    try {
                    	batchTask.packBak();
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    break;
                default:
            }
        }

    }

    public class ThreadRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                System.out.println("开始执行batch");
                String batch = batchService.getBasicInfo(PO_IMPORT);
                if(batch != null){
                    setPoImport(batch);
                }
                batch = batchService.getBasicInfo(PACK_BAK);
                if(batch != null){
                	setPackBak(batch);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Component
    public class BatchApplicationRunner implements ApplicationRunner {
        @Override
        public void run(ApplicationArguments applicationArguments) throws Exception {
            Thread thread = new Thread(new ThreadRunner());
            thread.start();
        }
    }
}