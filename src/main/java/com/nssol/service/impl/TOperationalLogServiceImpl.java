package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.PlanningInfoDao;
import com.nssol.dao.master.TOperationalLogDao;
import com.nssol.dao.master.TPackDao;

import com.nssol.model.T_OperationalLog;
import com.nssol.model.T_Planning_Info;
import com.nssol.service.PlanningInfoService;
import com.nssol.service.TOperationalLogService;


@Service
@Transactional
public class TOperationalLogServiceImpl implements TOperationalLogService {

	@Autowired
	private  TOperationalLogDao operationalLogDao;
	
	@Autowired
	private PlanningInfoService planInfoService;

	@Autowired
	private  PlanningInfoDao planningInfoDao;
	
	@Autowired
	private  TPackDao packDao;
	
	@Override
	public List<T_Planning_Info> insertOperationalLog(T_OperationalLog tOperationalLog) {
		
		// 更新计划
		T_Planning_Info planInfo=new T_Planning_Info();
		planInfo.setPlanningNum(tOperationalLog.getPlanningNum());
		planInfo.setProLine(tOperationalLog.getProLine());	
		planInfo.setOrderNo(tOperationalLog.getOrderNo());
		planInfo.setdONo(tOperationalLog.getdONo());
		planInfo.setSetCode(tOperationalLog.getSetCode());
		planInfo.setScanedQty(tOperationalLog.getScanedQty());
		planInfo.setScanedQty_Fail(tOperationalLog.getScanedQty_Fail());
		planInfo.setScanedQty_Add(tOperationalLog.getScanedQty_Add());
		planInfo.setScanedQty_Subtract(tOperationalLog.getScanedQty_Subtract());
		planInfo.setModifyer(tOperationalLog.getModifyer());
		planInfo.setModifyTime(tOperationalLog.getOptTime());
		
		if(tOperationalLog.getOptType().equals("2")) {
		   planningInfoDao.UpdatePlanningInfoByManual(planInfo);
		}else {
			planningInfoDao.UpdatePlanningInfoBySetCode(planInfo);	
		}
		
//		// 保存捆包信息（UQ）
//		if(tOperationalLog.getOptType().equals("0")) {
//		  packDao.insertPackInfo(tOperationalLog.getPackInfo());
//		}	
		
		// 保存捆包信息（非UQ）
		if(tOperationalLog.getOptType().equals("3")) {
			  tOperationalLog.setOptType("0");
			  packDao.insertPackAndDetail(tOperationalLog.getPackInfo());
			}	
		
		// 插入日志  异常状态
		if(!tOperationalLog.getOptType().equals("0")) {
		  operationalLogDao.insertOperationalLog(tOperationalLog);
		}
		
		 // 获取新计划任务
		T_Planning_Info planInfoSearch=new T_Planning_Info();
		planInfoSearch.setProLine(tOperationalLog.getProLine());	
		planInfoSearch.setIsScaned(2);
		 List<T_Planning_Info>  retList=planInfoService.getPlanningInfoListByLine(planInfoSearch);
		return retList;
	}
	
	@Override
	public List<T_OperationalLog> getLogListByPage(T_OperationalLog tOperationalLog){

	         // 获取总条数
			List<T_OperationalLog> bagging=operationalLogDao.selectTotLoglist(tOperationalLog);
			Integer startNum=(tOperationalLog.getCurrentPageNumber() - 1) * tOperationalLog.getCurrentPageShowCounts();
			Integer endNum=tOperationalLog.getCurrentPageShowCounts() * tOperationalLog.getCurrentPageNumber();
				
			tOperationalLog.setStartRecord(startNum);
			tOperationalLog.setEndRecord(endNum);
			List<T_OperationalLog> LogList = operationalLogDao.getLogListByPage(tOperationalLog);
			Integer recoreCounts =0;
			if(bagging!=null && !bagging.isEmpty()) {
					recoreCounts=bagging.size();
				}
			Integer pageCounts= (recoreCounts + tOperationalLog.getCurrentPageShowCounts() - 1) / tOperationalLog.getCurrentPageShowCounts();
			if(recoreCounts>0)
				{
					if(tOperationalLog.getCurrentPageShowCounts()<=0) {
						LogList.get(0).setPagesCount(0);
					}else {
						LogList.get(0).setPagesCount(pageCounts);
					}
					if(tOperationalLog.getCurrentPageNumber()<pageCounts) {
						LogList.get(0).setCurrentPageRecordCounts(tOperationalLog.getCurrentPageShowCounts());
					}else {
						LogList.get(0).setCurrentPageRecordCounts(recoreCounts % tOperationalLog.getCurrentPageShowCounts());
					}
					 if (LogList.get(0).getCurrentPageRecordCounts() == 0) {
						 LogList.get(0).setCurrentPageRecordCounts (tOperationalLog.getCurrentPageShowCounts());
					 }
					 LogList.get(0).setRecordCounts(recoreCounts);
					 LogList.get(0).setCurrentPageShowCounts(tOperationalLog.getCurrentPageShowCounts());
					 LogList.get(0).setCurrentPageNumber(tOperationalLog.getCurrentPageNumber());
				}
		return LogList;
	}
}
