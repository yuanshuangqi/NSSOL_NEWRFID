package com.nssol.service;

import java.util.List;

import com.nssol.model.TSetInfo;

public interface TSetInfoService {
	
	public List<TSetInfo> getPackingCartonByPage(TSetInfo setInfo);
	
	public TSetInfo getSetInfoBysetCode(TSetInfo setInfo);
}
	

