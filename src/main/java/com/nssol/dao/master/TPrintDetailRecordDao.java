package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_Print_Detail_Record;

@Mapper
public interface TPrintDetailRecordDao {

	void insertPrintDetailRecord(List<T_Print_Detail_Record> detailList);

}
