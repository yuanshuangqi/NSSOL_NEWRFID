package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.PlanningData;
import com.nssol.model.T_Planning_Detail;
import com.nssol.model.T_Planning_Info;

@Mapper
public interface MasterPlanningHistoryInfo {

	int insertPlanningData(PlanningData planningData);

	int insertPlanningDetail(List<T_Planning_Detail> lsPlanningData);
	
	int delPlanningInfo(PlanningData planningData);

	int delPlanningDetail(T_Planning_Detail planDt);

	int upDatePlanningInfo(PlanningData planningData);

	int delUpPlanningDetail(T_Planning_Detail planDt);

	int delUpPlanningInfo(PlanningData planningData);

	T_Planning_Info getPlanning(PlanningData planningData);

	List<T_Planning_Detail> getPlanningDetail(T_Planning_Detail planDt);
	
	int updatePlanningInfoImportFlg(PlanningData planningData);
	
	List<T_Planning_Info> getPlanningList();

}
