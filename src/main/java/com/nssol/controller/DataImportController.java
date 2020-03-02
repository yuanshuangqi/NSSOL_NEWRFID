package com.nssol.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.nssol.controller.response.DataImportResponse;
import com.nssol.service.BatchService;
import com.nssol.service.po_import.PoImportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = { "Operatioms about Data Import" })
public class DataImportController {
	
	@Autowired
	private PoImportService poImportService;

	 @Autowired
	 private BatchService batchService;

	@ApiOperation(value = "PO数据同步", notes = "数据同步", produces = "application/json")
    @RequestMapping(value = "/poImport", method = RequestMethod.GET)
	public DataImportResponse poImport(){
		poImportService.synBatch();
		DataImportResponse dataImportResponse = new DataImportResponse();
		dataImportResponse.setMessage("success");
		return dataImportResponse;
	}
	
	@ApiOperation(value = "计划任务手动同步", notes = "计划任务数据同步", produces = "application/json")
    @RequestMapping(value = "/planningInfoImport", method = RequestMethod.GET)
	public DataImportResponse planningInfoImport(){
		batchService.insertPlanningDataBatch();
		DataImportResponse dataImportResponse = new DataImportResponse();
		dataImportResponse.setMessage("success");
		return dataImportResponse;
	}
}
