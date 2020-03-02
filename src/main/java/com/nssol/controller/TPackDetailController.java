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
import com.nssol.model.T_Pack;
import com.nssol.service.TPackDetailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about TPackDetail" })
public class TPackDetailController {

	@Autowired
	private TPackDetailService tPackDetailService;
	
	@ApiOperation(value = "判断捆包内容是否存在", notes = "判断捆包内容是否存在", produces = "application/json")
	 @RequestMapping(value = "/getPacKDetailIsExist", method = RequestMethod.POST)
		public String getPacKDetailIsExist(@RequestBody TPackRequest packRequest){
			
			T_Pack pack=new T_Pack();
			BeanUtils.copyProperties(packRequest, pack);
		 return  tPackDetailService.getPacKDetailIsExist(pack.getPackDetailList());
		}
	
}