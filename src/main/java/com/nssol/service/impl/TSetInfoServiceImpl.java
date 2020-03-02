package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.MasterSetDetailDao;
import com.nssol.dao.master.PlanningDetailDao;
import com.nssol.dao.master.PlanningInfoDao;
import com.nssol.dao.master.TSetDetailDao;
import com.nssol.dao.master.TSetInfoDao;
import com.nssol.model.TSetDetail;
import com.nssol.model.TSetInfo;
import com.nssol.model.T_Pack;
import com.nssol.model.T_Planning_Detail;
import com.nssol.model.T_Planning_Info;
import com.nssol.model.T_SET_DETAIL;
import com.nssol.service.PlanningInfoService;
import com.nssol.service.TSetInfoService;


@Service
@Transactional
public class TSetInfoServiceImpl implements TSetInfoService {

	@Autowired
	private  TSetInfoDao setInfoDao;
	
	@Autowired
	private TSetDetailDao setDetailtDao;
	
	@Override
	public List<TSetInfo> getPackingCartonByPage(TSetInfo setInfo){

	         // 获取总条数
			List<TSetInfo> setTotList=setInfoDao.selectTotPackingCartonlist(setInfo);
			Integer startNum=(setInfo.getCurrentPageNumber() - 1) * setInfo.getCurrentPageShowCounts();
			Integer endNum=setInfo.getCurrentPageShowCounts() * setInfo.getCurrentPageNumber();
				
			setInfo.setStartRecord(startNum);
			setInfo.setEndRecord(endNum);
			List<TSetInfo> setInfoList = setInfoDao.getPackingCartonByPage(setInfo);
			Integer recoreCounts =0;
			if(setTotList!=null && !setTotList.isEmpty()) {
					recoreCounts=setTotList.size();
				}
			Integer pageCounts= (recoreCounts + setInfo.getCurrentPageShowCounts() - 1) / setInfo.getCurrentPageShowCounts();
			if(recoreCounts>0)
				{
					if(setInfo.getCurrentPageShowCounts()<=0) {
						setInfoList.get(0).setPagesCount(0);
					}else {
						setInfoList.get(0).setPagesCount(pageCounts);
					}
					if(setInfo.getCurrentPageNumber()<pageCounts) {
						setInfoList.get(0).setCurrentPageRecordCounts(setInfo.getCurrentPageShowCounts());
					}else {
						setInfoList.get(0).setCurrentPageRecordCounts(recoreCounts % setInfo.getCurrentPageShowCounts());
					}
					 if (setInfoList.get(0).getCurrentPageRecordCounts() == 0) {
						 setInfoList.get(0).setCurrentPageRecordCounts (setInfo.getCurrentPageShowCounts());
					 }
					 setInfoList.get(0).setRecordCounts(recoreCounts);
					 setInfoList.get(0).setCurrentPageShowCounts(setInfo.getCurrentPageShowCounts());
					 setInfoList.get(0).setCurrentPageNumber(setInfo.getCurrentPageNumber());
				}
		return setInfoList;
	}
	
	@Override
	public TSetInfo getSetInfoBysetCode(TSetInfo setInfo){
		
		TSetInfo retInfo = setInfoDao.getSetInfoBysetCode(setInfo);
		
		TSetDetail setDetail =new TSetDetail();
		setDetail.setOrderNo(setInfo.getOrderNo());
		setDetail.setdONo(setInfo.getdONo());
		setDetail.setSetCode(setInfo.getSetCode());
		
		List<TSetDetail> setDetailList=setDetailtDao.getSetDetailList(setDetail);
		retInfo.setSetDetailList(setDetailList);
		
		return retInfo;
	}
}
