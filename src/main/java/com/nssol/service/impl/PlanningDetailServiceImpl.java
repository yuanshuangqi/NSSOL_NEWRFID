package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.PlanningDetailDao;
import com.nssol.model.T_Planning_Detail;
import com.nssol.service.PlanningDetailService;



@Service
@Transactional
public class PlanningDetailServiceImpl implements PlanningDetailService {

	@Autowired
	private  PlanningDetailDao planDao;

	@Override
	public List<T_Planning_Detail>  getPlanningDetailBySetCode(T_Planning_Detail planningData) {
		List<T_Planning_Detail> retPlanningList=planDao.getPlanDetailBySetCode(planningData);
		return retPlanningList;
	}

}
