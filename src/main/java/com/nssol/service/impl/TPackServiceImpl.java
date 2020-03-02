package com.nssol.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TPackDao;
import com.nssol.dao.master.TPackDetailDao;
import com.nssol.model.T_Pack;
import com.nssol.model.T_Pack_Detail;
import com.nssol.service.TPackService;


@Service
@Transactional
public class TPackServiceImpl implements TPackService {

	@Autowired
	private  TPackDao packDao;
	
	@Autowired
	private  TPackDetailDao packDetailDao;

	@Override
	public List<T_Pack> getPackListByPage(T_Pack tPack){

	         // 获取总条数
			List<T_Pack> packTotList=packDao.selectTotPacklist(tPack);
			Integer startNum=(tPack.getCurrentPageNumber() - 1) * tPack.getCurrentPageShowCounts();
			Integer endNum=tPack.getCurrentPageShowCounts() * tPack.getCurrentPageNumber();
				
			tPack.setStartRecord(startNum);
			tPack.setEndRecord(endNum);
			List<T_Pack> packList = packDao.getPackListByPage(tPack);
			Integer recoreCounts =0;
			if(packTotList!=null && !packTotList.isEmpty()) {
					recoreCounts=packTotList.size();
				}
			Integer pageCounts= (recoreCounts + tPack.getCurrentPageShowCounts() - 1) / tPack.getCurrentPageShowCounts();
			if(recoreCounts>0)
				{
					if(tPack.getCurrentPageShowCounts()<=0) {
						packList.get(0).setPagesCount(0);
					}else {
						packList.get(0).setPagesCount(pageCounts);
					}
					if(tPack.getCurrentPageNumber()<pageCounts) {
						packList.get(0).setCurrentPageRecordCounts(tPack.getCurrentPageShowCounts());
					}else {
						packList.get(0).setCurrentPageRecordCounts(recoreCounts % tPack.getCurrentPageShowCounts());
					}
					 if (packList.get(0).getCurrentPageRecordCounts() == 0) {
						 packList.get(0).setCurrentPageRecordCounts (tPack.getCurrentPageShowCounts());
					 }
					 packList.get(0).setRecordCounts(recoreCounts);
					 packList.get(0).setCurrentPageShowCounts(tPack.getCurrentPageShowCounts());
					 packList.get(0).setCurrentPageNumber(tPack.getCurrentPageNumber());
				}
		return packList;
	}
	
	@Override
	public List<String> deletePackInfo(List<T_Pack> packList){

		List<String> errorList=new ArrayList<String>();
		if(packList!=null && packList.size()!=0) {
			for(T_Pack info:packList){
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("deleter", info.getModifyer());
				map.put("innerPackNum", info.getInnerPackNum());
				map.put("comment", info.getComment());
				map.put("errorMsg", "");
				packDao.deletePack(map);
				String error=map.get("errorMsg").toString();
				if(error.length()>0) {
					errorList.add(info.getInnerPackNum()+":"+error);
				}
			}
		}
		
		return errorList;
	}

	@Override
	public String insertPackAndDetail(T_Pack tPack){

		String retMsg="";
		
		List<T_Pack_Detail> retList=tPack.getPackDetailList();
		
		List<T_Pack_Detail> packDetailList=packDetailDao.getPacKDetailIsExist(retList);
	    
		if(packDetailList!=null && !packDetailList.isEmpty()) {
			
			retMsg="pack_repeat";
		}else {
			packDao.insertPackAndDetail(tPack);		
		}
		return retMsg;		
}

}
