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
import com.nssol.controller.request.TPackRequest;
import com.nssol.controller.request.TSetInfoRequest;
import com.nssol.controller.response.PlanningInfoResponse;
import com.nssol.controller.response.TPackResponse;
import com.nssol.controller.response.TSetInfoRespnse;
import com.nssol.model.TSetInfo;
import com.nssol.model.T_Pack;
import com.nssol.model.T_PackNum_Bind;
import com.nssol.model.T_Planning_Detail;
import com.nssol.model.T_Planning_Info;

import com.nssol.service.PlanningDetailService;
import com.nssol.service.PlanningInfoService;
import com.nssol.service.TPackNumBindService;
import com.nssol.service.TSetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about T_PackNum_Bind" })
public class TPackNumBindController {
	
	@Autowired
	private TPackNumBindService packNumService;

	
	 @ApiOperation(value = "获取对应的箱号信息", notes = "查询T_PackNum_Bind信息", produces = "application/json")
	 @RequestMapping(value = "/getPackNumByHandlingUnitID", method = RequestMethod.POST)
		public T_PackNum_Bind getPackNumByHandlingUnitID(@RequestBody T_PackNum_Bind packNumRequest){
		 T_PackNum_Bind lstResponse= new T_PackNum_Bind();
		 lstResponse=packNumService.getPackNumByHandlingUnitID(packNumRequest);
			return lstResponse;
		}
	 
		
			
}
