package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_Print_Record;

@Mapper
public interface TPrintRecordDao {

	void insertPrintRrcord(T_Print_Record printRecord);
	
	Long getPrintNum();
}
