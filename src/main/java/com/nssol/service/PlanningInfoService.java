package com.nssol.service;

import java.util.List;

import com.nssol.model.T_Planning_Info;

public interface PlanningInfoService {

	public List<T_Planning_Info> getPlanningInfoListByLine(T_Planning_Info planningData) ;
	
	public List<T_Planning_Info> getPlanningInfoListByPage(T_Planning_Info planningData);
}
	

