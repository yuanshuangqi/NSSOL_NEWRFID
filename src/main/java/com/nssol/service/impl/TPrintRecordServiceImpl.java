package com.nssol.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.nssol.common.CommonUnit;
import com.nssol.config.HttpPostConfig;
import com.nssol.controller.response.MessageResponse;
import com.nssol.dao.master.TPrintDetailRecordDao;
import com.nssol.dao.master.TPrintRecordDao;
import com.nssol.model.T_Print_Detail_Pass;
import com.nssol.model.T_Print_Detail_Record;
import com.nssol.model.T_Print_Pass;
import com.nssol.model.T_Print_Record;
import com.nssol.model.T_Print_Result;
import com.nssol.model.T_ProductionLine;
import com.nssol.service.TPrintRecordService;


@Service
@Transactional
public class TPrintRecordServiceImpl implements TPrintRecordService {

	@Autowired
	private  TPrintRecordDao printDao;
	
	@Autowired
	private TPrintDetailRecordDao printDetailDao;
	
    @Value("${interfaceUrl.postUrl}")
	private String url;
	
	@Override
	public MessageResponse insertPrintRecord(T_Print_Record printRecord){
		MessageResponse messageResponse = new MessageResponse();
		
		try{// GUID 
		String guid=CommonUnit.getUUID();
		printRecord.setiD(guid);
		
		// 顺序号
		Long printSeqNum =printDao.getPrintNum();
		printRecord.setSeqNum(printSeqNum);
		
		T_Print_Pass printPass=new T_Print_Pass();
		// 产线编码
		printPass.setLine(printRecord.getProLine());
		// 任务单号
		printPass.setWo(printRecord.getPlanningNum());
		// 序列
		printPass.setXh(printSeqNum);
		// 打印张数
		printPass.setNum(printRecord.getPrintNum());
		// OLD:老标签、NEW:新标签
		printPass.setType(printRecord.getNewFlg());
		
		List<T_Print_Detail_Pass> detailPass=new ArrayList<T_Print_Detail_Pass>();
		List<T_Print_Detail_Record> printDetailList= new ArrayList<T_Print_Detail_Record>();
		 
		 for(T_Print_Detail_Record info:printRecord.getPrintDetailList()){
			 T_Print_Detail_Record printDetailRecord = new T_Print_Detail_Record();
			
				BeanUtils.copyProperties(info, printDetailRecord);
				printDetailRecord.setPrintID(guid);
				printDetailList.add(printDetailRecord);
				
				T_Print_Detail_Pass detPass=new T_Print_Detail_Pass();
				detPass.setLabelBody(info.getPrintContent());
				detPass.setLabelType(info.getPrintModel());
				detailPass.add(detPass);
			}
		
		 // 明细数据
		 printPass.setDetail(detailPass);
		 
		// 传输json
		 String data = JSON.toJSONString(printPass);
		
		 // 调用第三方http协议
		String outputContent=HttpPostConfig.httpPostCase(url, data);
		
	// 设置返回结果
		printRecord.setRetReault(outputContent);
		
	//		ArrayList<T_ProductionLine> plan  = 
	//				JSON.parseObject(outputContent, new TypeReference<ArrayList<T_ProductionLine>>(){});
	//     
	//		
		T_Print_Result  printResult  = JSON.parseObject(outputContent, new TypeReference<T_Print_Result>(){});

		 messageResponse.setCode(printResult.getResult());
		 messageResponse.setMessage(printResult.getMsg());
		printDao.insertPrintRrcord(printRecord);
		printDetailDao.insertPrintDetailRecord(printDetailList);
		 } catch (Exception e) {
	            e.printStackTrace();
	            messageResponse.setCode("ERROR");
	   		 messageResponse.setMessage("发生异常"); 
	        }
		return messageResponse;
	}
}
