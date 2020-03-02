package com.nssol.service;

import java.util.List;

import com.nssol.model.T_OperationalLog;
import com.nssol.model.T_Planning_Info;

public interface TOperationalLogService {

	public List<T_Planning_Info> insertOperationalLog(T_OperationalLog tOperationalLog) ;
	
	public List<T_OperationalLog> getLogListByPage(T_OperationalLog tOperationalLog);
	
}
	

