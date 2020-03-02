package com.nssol.service;

import com.nssol.controller.response.MessageResponse;
import com.nssol.model.PlanningData;

public interface BatchService {
    public String getBasicInfo(String batchName);

    public void setBasicInfo(String batchName,String batchCron);

	public MessageResponse insertPlanningData(PlanningData planningData);
	
	public void insertPlanningDataBatch();

}
