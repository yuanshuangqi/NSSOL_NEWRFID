package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_OperationalLog;

@Mapper
public interface TOperationalLogDao {
	
	void insertOperationalLog(T_OperationalLog tOperationalLog);
	
	List<T_OperationalLog> getLogListByPage(T_OperationalLog tOperationalLog);
	
	List<T_OperationalLog> selectTotLoglist(T_OperationalLog tOperationalLog);
}
