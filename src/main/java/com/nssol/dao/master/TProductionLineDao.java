package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_ProductionLine;

@Mapper
public interface TProductionLineDao {
	
	List<T_ProductionLine> getProductionLineList();
	
}
