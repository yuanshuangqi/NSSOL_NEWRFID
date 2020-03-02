package com.nssol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nssol.dao.master.TProductionLineDao;
import com.nssol.model.T_ProductionLine;
import com.nssol.service.TProductionLineService;

@Service
@Transactional
public class TProductionLineServiceImpl implements TProductionLineService {

	@Autowired
	private  TProductionLineDao productionLineDao;
	

	@Override
	public List<T_ProductionLine>  getProductionLineList() {
		
		return productionLineDao.getProductionLineList();
	}
}
