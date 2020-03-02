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
import com.nssol.model.T_Planning_Detail;
import com.nssol.model.T_Planning_Info;

import com.nssol.service.PlanningDetailService;
import com.nssol.service.PlanningInfoService;
import com.nssol.service.TSetInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about T_Set_Info" })
public class TSetInfoController {
	
	@Autowired
	private TSetInfoService setService;

	
	 @ApiOperation(value = "获取捆包信息", notes = "查询T_Set_Info信息", produces = "application/json")
	 @RequestMapping(value = "/getPackingCartonByPage", method = RequestMethod.POST)
		public List<TSetInfoRespnse> getPlanningInfoListByPage(@RequestBody TSetInfoRequest tplanRequest){
			List<TSetInfoRespnse> lstResponse= new ArrayList<TSetInfoRespnse>();
			TSetInfo setInfo=new TSetInfo();
			BeanUtils.copyProperties(tplanRequest,setInfo);

			// 获取对应信息
			List<TSetInfo> setInfoList= setService.getPackingCartonByPage(setInfo);

					if(setInfoList!=null && !setInfoList.isEmpty()) {
						TSetInfoRespnse setResponse = null;
						for(TSetInfo info:setInfoList){
							setResponse = new TSetInfoRespnse();
							BeanUtils.copyProperties(info, setResponse);
							lstResponse.add(setResponse);
						}
					}
			 
			return lstResponse;
		}
	 
	 @ApiOperation(value = "通过dono、setCode获取捆包信息", notes = "查询T_Set_Info信息", produces = "application/json")
	 @RequestMapping(value = "/getSetInfoBysetCode", method = RequestMethod.POST)
		public TSetInfoRespnse getSetInfoBysetCode(@RequestBody TSetInfoRequest tplanRequest){
			TSetInfoRespnse lstResponse= new TSetInfoRespnse();
			TSetInfo setInfo=new TSetInfo();
			BeanUtils.copyProperties(tplanRequest,setInfo);
			
			// 获取对应信息
			TSetInfo retInfo= setService.getSetInfoBysetCode(setInfo);
			BeanUtils.copyProperties(retInfo, lstResponse);
			
			return lstResponse;
		}	
			
}
