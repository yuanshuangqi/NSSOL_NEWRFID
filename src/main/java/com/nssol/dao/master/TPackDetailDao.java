package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_Pack_Detail;

@Mapper
public interface TPackDetailDao {

	List<T_Pack_Detail> getPacKDetailIsExist(List<T_Pack_Detail> tPackDetail);
		
}
