package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.PlanningDetailDao;
import com.nssol.dao.master.PlanningInfoDao;
import com.nssol.model.T_Pack;
import com.nssol.model.T_Planning_Detail;
import com.nssol.model.T_Planning_Info;
import com.nssol.service.PlanningInfoService;


@Service
@Transactional
public class PlanningInfoServiceImpl implements PlanningInfoService {

	@Autowired
	private  PlanningInfoDao planDao;
	
	@Autowired
	private PlanningDetailDao planDetailDao;
	@Override
	public List<T_Planning_Info>  getPlanningInfoListByLine(T_Planning_Info planningData) {
		
		List<T_Planning_Info> retPlanningList=planDao.getPlanningInfoList(planningData);

		if(retPlanningList!=null && !retPlanningList.isEmpty()) {
		
			// 获取当前明细信息
			T_Planning_Info currPlan=retPlanningList.get(0);
			T_Planning_Detail tPlanDetail= new T_Planning_Detail();
			

			tPlanDetail.setPlanningNum(currPlan.getPlanningNum());
			List<T_Planning_Detail> planDetailInfo=planDetailDao.getPlanDetailBySetCode(tPlanDetail);
			
			currPlan.setLsPlanningDetail(planDetailInfo);
		}
		return retPlanningList;
	}
	
	@Override
	public List<T_Planning_Info> getPlanningInfoListByPage(T_Planning_Info planningData){

	         // 获取总条数
			List<T_Planning_Info> packTotList=planDao.selectTotPlanningInfolist(planningData);
			Integer startNum=(planningData.getCurrentPageNumber() - 1) * planningData.getCurrentPageShowCounts();
			Integer endNum=planningData.getCurrentPageShowCounts() * planningData.getCurrentPageNumber();
				
			planningData.setStartRecord(startNum);
			planningData.setEndRecord(endNum);
			List<T_Planning_Info> packList = planDao.getPlanningInfoListByPage(planningData);
			Integer recoreCounts =0;
			if(packTotList!=null && !packTotList.isEmpty()) {
					recoreCounts=packTotList.size();
				}
			Integer pageCounts= (recoreCounts + planningData.getCurrentPageShowCounts() - 1) / planningData.getCurrentPageShowCounts();
			if(recoreCounts>0)
				{
					if(planningData.getCurrentPageShowCounts()<=0) {
						packList.get(0).setPagesCount(0);
					}else {
						packList.get(0).setPagesCount(pageCounts);
					}
					if(planningData.getCurrentPageNumber()<pageCounts) {
						packList.get(0).setCurrentPageRecordCounts(planningData.getCurrentPageShowCounts());
					}else {
						packList.get(0).setCurrentPageRecordCounts(recoreCounts % planningData.getCurrentPageShowCounts());
					}
					 if (packList.get(0).getCurrentPageRecordCounts() == 0) {
						 packList.get(0).setCurrentPageRecordCounts (planningData.getCurrentPageShowCounts());
					 }
					 packList.get(0).setRecordCounts(recoreCounts);
					 packList.get(0).setCurrentPageShowCounts(planningData.getCurrentPageShowCounts());
					 packList.get(0).setCurrentPageNumber(planningData.getCurrentPageNumber());
				}
		return packList;
	}
}
