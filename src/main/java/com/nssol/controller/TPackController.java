package com.nssol.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.nssol.controller.request.TPackRequest;
import com.nssol.controller.response.TPackResponse;
import com.nssol.model.T_Pack;
import com.nssol.service.TPackService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TPack" })
public class TPackController {

	@Autowired
	private TPackService tPackService;
	

	@ApiOperation(value = "获取捆包信息", notes = "查询T_Pack信息", produces = "application/json")
	 @RequestMapping(value = "/getPackListByPage", method = RequestMethod.POST)
		public List<TPackResponse> getPackListByPage(@RequestBody TPackRequest tpackRequest){
			List<TPackResponse> lstResponse= new ArrayList<TPackResponse>();
			T_Pack tpack=new T_Pack();
			BeanUtils.copyProperties(tpackRequest, tpack);

			// 获取对应的未完成的计划任务
					List<T_Pack> packList= tPackService.getPackListByPage(tpack);

					if(packList!=null && !packList.isEmpty()) {
						TPackResponse packResponse = null;
						for(T_Pack info:packList){
							packResponse = new TPackResponse();
							BeanUtils.copyProperties(info, packResponse);
							lstResponse.add(packResponse);
						}
					}
			 
			return lstResponse;
		}
	
	@ApiOperation(value = "删除捆包信息", notes = "删除T_Pack信息", produces = "application/json")
	 @RequestMapping(value = "/deletePackInfo", method = RequestMethod.POST)
		public List<String> deletePackInfo(@RequestBody List<TPackRequest> packRequestList){
			
			List<T_Pack> packList=new ArrayList<T_Pack>();
			for(TPackRequest info:packRequestList){
				T_Pack pack = new T_Pack();
				BeanUtils.copyProperties(info, pack);
				packList.add(pack);
			}
			BeanUtils.copyProperties(packRequestList, packList);

			// 删除捆包信息
			return tPackService.deletePackInfo(packList);
		}
	
	
	@ApiOperation(value = "插入捆包信息", notes = "插入T_Pack信息", produces = "application/json")
	 @RequestMapping(value = "/insertPackAndDetail", method = RequestMethod.POST)
		public String insertPackAndDetail(@RequestBody TPackRequest packRequest){
			
			T_Pack pack=new T_Pack();
			BeanUtils.copyProperties(packRequest, pack);
		 return  tPackService.insertPackAndDetail(pack);
		}
	
}