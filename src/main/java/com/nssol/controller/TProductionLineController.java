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
import com.nssol.controller.response.PlanningInfoResponse;
import com.nssol.controller.response.TBasicInfoResponse;
import com.nssol.controller.response.TProductionLineResponse;
import com.nssol.model.TBasicInfo;
import com.nssol.model.T_Planning_Info;
import com.nssol.model.T_ProductionLine;
import com.nssol.service.TBasicInfoService;
import com.nssol.service.TProductionLineService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TProductionLine" })
public class TProductionLineController {

	@Autowired
	private TProductionLineService productionLineService;
	
	@ApiOperation(value = "获取产线", notes = "查询数据库T_ProductionLine信息", produces = "application/json")
	
    @RequestMapping(value = "/getProductionLineList", method = RequestMethod.POST)
	public List<TProductionLineResponse> getProductionLineList(){
		

		 List<T_ProductionLine> productionLineList = productionLineService.getProductionLineList();
		
		 List<TProductionLineResponse> lstResponse= new ArrayList<TProductionLineResponse>();
		 if(productionLineList!=null && !productionLineList.isEmpty()) {
			 TProductionLineResponse proLine = null;
				
				for(T_ProductionLine planInfo:productionLineList){
					proLine = new TProductionLineResponse();
					BeanUtils.copyProperties(planInfo, proLine);
					lstResponse.add(proLine);
				}
			}
		return lstResponse;
	}
	
}