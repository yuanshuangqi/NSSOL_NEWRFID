package com.nssol.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TPackDetailDao;
import com.nssol.model.T_Pack_Detail;
import com.nssol.service.TPackDetailService;


@Service
@Transactional
public class TPackDetailServiceImpl implements TPackDetailService {

	@Autowired
	private  TPackDetailDao packDetailDao;

	@Override
	public String getPacKDetailIsExist(List<T_Pack_Detail> packDetailList){

		String retMsg="";
		
		List<T_Pack_Detail> packDetail=packDetailDao.getPacKDetailIsExist(packDetailList);
	    
		if(packDetail!=null && !packDetail.isEmpty()) {
			
			retMsg="pack_repeat";
		}
		return retMsg;		
}

}
