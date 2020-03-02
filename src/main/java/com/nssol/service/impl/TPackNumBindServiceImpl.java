package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TPackDao;
import com.nssol.dao.master.TPackNumBindDao;
import com.nssol.model.T_Pack;
import com.nssol.model.T_PackNum_Bind;
import com.nssol.service.TPackNumBindService;


@Service
@Transactional
public class TPackNumBindServiceImpl implements TPackNumBindService {

	@Autowired
	private  TPackNumBindDao packNumDao;
	
	@Autowired
	private  TPackDao packDao;
	
		
	@Override
	public T_PackNum_Bind getPackNumByHandlingUnitID(T_PackNum_Bind packNumBind){
		
		T_PackNum_Bind retInfo =new T_PackNum_Bind();
		retInfo= packNumDao.getPackNumByHandlingUnitID(packNumBind);
		T_Pack tPack=new T_Pack();
		tPack.setHandlingUnitID(packNumBind.getHandlingUnitID());
		T_Pack pack=packDao.getPackIsExistByHandlingUnitID(tPack);
		if(pack!=null  && !pack.getHandlingUnitID().isEmpty()) {
			if(retInfo==null) {
				retInfo =new T_PackNum_Bind();
			}
			retInfo.setIsUserd("1");
		}
		
		return retInfo;
	}
}
