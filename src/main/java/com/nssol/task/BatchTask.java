package com.nssol.task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nssol.service.po_import.PoImportService;
import org.springframework.util.StringUtils;



@Component
public class BatchTask {

	@Autowired
	private PoImportService poImportService;
	
	/**
	 * 每天0，6,12,18点运行一次 更新PO等信息
	 */
	//@Scheduled(cron="0 0 0,6,12,18 * * ? ")
	public void poImport(){
		poImportService.synBatch();
	}

	/**
	 * 每天0，6,12,18点运行一次 更新PK等信息
	 * @throws Exception 
	 */
	public void packBak() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("errorMsg", null);
		poImportService.packBak(map);
		if(!StringUtils.isEmpty(map.get("errorMsg"))) {
			throw new Exception((String)map.get("errorMsg"));
		}
	}
}
