package com.nssol.service;

import java.util.List;

import com.nssol.model.T_Pack;


public interface TPackService {

    public List<T_Pack> getPackListByPage(T_Pack tpack);
	
	public List<String> deletePackInfo(List<T_Pack> packList);
	
	public String insertPackAndDetail(T_Pack tPack);
	
}
	

