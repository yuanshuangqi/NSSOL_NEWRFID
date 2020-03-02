package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_PackNum_Bind;

@Mapper
public interface TPackNumBindDao {
	
	T_PackNum_Bind getPackNumByHandlingUnitID(T_PackNum_Bind packNumBind);
}
