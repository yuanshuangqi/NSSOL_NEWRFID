package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_Planning_Detail;

@Mapper
public interface PlanningDetailDao {
	
	List<T_Planning_Detail> getPlanDetailBySetCode(T_Planning_Detail planDetail);
	
}
