package com.nssol.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.request.PlanningInfoRequest;
import com.nssol.controller.response.PlanningInfoResponse;
import com.nssol.model.T_Planning_Info;
import com.nssol.service.PlanningInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about PlanningInfo" }) 
public class PlanningInfoController {

	@Autowired
	private PlanningInfoService planService;

	
	@ApiOperation(value = "获取未完成计划信息", notes = "通过产线获取对应的未完成计划信息", produces = "application/json")
	@RequestMapping(value = "/getPlanningInfoListByLine", method = RequestMethod.POST)
	public List<PlanningInfoResponse> getPlanningInfoListByLine(@RequestBody PlanningInfoRequest planingRequest){
		List<PlanningInfoResponse> lstResponse= new ArrayList<PlanningInfoResponse>();
		T_Planning_Info tPlanInfo= new T_Planning_Info();
		BeanUtils.copyProperties(planingRequest, tPlanInfo);
		
		// 获取对应的未完成的计划任务
		List<T_Planning_Info> planInfoList= planService.getPlanningInfoListByLine(tPlanInfo);

		
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
	
	 @ApiOperation(value = "获取计划信息", notes = "查询T_PlanningInfo信息", produces = "application/json")
	 @RequestMapping(value = "/getPlanningInfoListByPage", method = RequestMethod.POST)
	 public List<PlanningInfoResponse> getPlanningInfoListByPage(@RequestBody PlanningInfoRequest tplanRequest){
		List<PlanningInfoResponse> lstResponse= new ArrayList<PlanningInfoResponse>();
		T_Planning_Info planningInfo=new T_Planning_Info();
		BeanUtils.copyProperties(tplanRequest,planningInfo);

		// 获取对应的计划任务
		List<T_Planning_Info> planList= planService.getPlanningInfoListByPage(planningInfo);

				if(planList!=null && !planList.isEmpty()) {
					PlanningInfoResponse packResponse = null;
					for(T_Planning_Info info:planList){
						packResponse = new PlanningInfoResponse();
						BeanUtils.copyProperties(info, packResponse);
						lstResponse.add(packResponse);
					}
				}
		 
		return lstResponse;
	}
		
}
