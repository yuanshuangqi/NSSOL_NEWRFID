package com.nssol.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.TBasicInfoRequest;
import com.nssol.controller.request.TOperationalLogRequest;
import com.nssol.controller.response.PlanningInfoResponse;
import com.nssol.controller.response.TBasicInfoResponse;
import com.nssol.controller.response.TOperationalLogResponse;
import com.nssol.controller.response.TProductionLineResponse;
import com.nssol.model.TBasicInfo;
import com.nssol.model.T_OperationalLog;
import com.nssol.model.T_Planning_Info;
import com.nssol.model.T_ProductionLine;
import com.nssol.service.TBasicInfoService;
import com.nssol.service.TOperationalLogService;
import com.nssol.service.TProductionLineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TOperationalLog" })
public class TOperationalLogController {

	@Autowired
	private TOperationalLogService operationalLogService;
	
	@ApiOperation(value = "新增Log日志", notes = "新增T_OperationalLog信息", produces = "application/json")
	
    @RequestMapping(value = "/insertOperationalLog", method = RequestMethod.POST)
	public List<PlanningInfoResponse> insertOperationalLog(@RequestBody TOperationalLogRequest logRequest){
		List<PlanningInfoResponse> lstResponse= new ArrayList<PlanningInfoResponse>();
		T_OperationalLog optLog= new T_OperationalLog();
		BeanUtils.copyProperties(logRequest, optLog);

		// 获取对应的未完成的计划任务
				List<T_Planning_Info> planInfoList= operationalLogService.insertOperationalLog(optLog);

				if(planInfoList!=null && !planInfoList.isEmpty()) {
					PlanningInfoResponse plan = null;
					
					for(T_Planning_Info planInfo:planInfoList){
						plan = new PlanningInfoResponse();
						BeanUtils.copyProperties(planInfo, plan);
						lstResponse.add(plan);
					}
				}
		 
		return lstResponse;
	}
	
	@ApiOperation(value = "获取Log日志", notes = "查询T_OperationalLog信息", produces = "application/json")
	 @RequestMapping(value = "/getLogListByPage", method = RequestMethod.POST)
		public List<TOperationalLogResponse> getLogListByPage(@RequestBody TOperationalLogRequest logRequest){
			List<TOperationalLogResponse> lstResponse= new ArrayList<TOperationalLogResponse>();
			T_OperationalLog optLog= new T_OperationalLog();
			BeanUtils.copyProperties(logRequest, optLog);

			// 获取对应的未完成的计划任务
					List<T_OperationalLog> logList= operationalLogService.getLogListByPage(optLog);

					if(logList!=null && !logList.isEmpty()) {
						TOperationalLogResponse plan = null;
						for(T_OperationalLog planInfo:logList){
							plan = new TOperationalLogResponse();
							BeanUtils.copyProperties(planInfo, plan);
							lstResponse.add(plan);
						}
					}
			 
			return lstResponse;
		}
	
}