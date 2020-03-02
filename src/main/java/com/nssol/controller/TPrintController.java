package com.nssol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.response.MessageResponse;
import com.nssol.model.T_Print_Record;
import com.nssol.service.TPrintRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about T_PRINT_RECORD"})
public class TPrintController {

	@Autowired
	private TPrintRecordService tPrintService;

	@ApiOperation(value = "保存打印信息", notes = "保存T_PRINT_RECORD信息", produces = "application/json")
	 @RequestMapping(value = "/insertPrintReord", method = RequestMethod.POST)
		public MessageResponse insertPrintReord(@RequestBody T_Print_Record printRecord){
		  return tPrintService.insertPrintRecord(printRecord);
		}

}