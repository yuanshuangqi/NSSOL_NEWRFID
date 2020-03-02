package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_Pack;
import com.nssol.model.T_Planning_Info;

@Mapper
public interface PlanningInfoDao {
	
	List<T_Planning_Info> getPlanningInfoList(T_Planning_Info planningData);
	
	void UpdatePlanningInfoBySetCode(T_Planning_Info planningData);
	void UpdatePlanningInfoByManual(T_Planning_Info planningData);
	
    List<T_Planning_Info> getPlanningInfoListByPage(T_Planning_Info planningData);
	
	List<T_Planning_Info> selectTotPlanningInfolist(T_Planning_Info planningData);
}
