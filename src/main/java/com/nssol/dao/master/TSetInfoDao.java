package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.TSetInfo;

@Mapper
public interface TSetInfoDao {

	List<TSetInfo> getPackingCartonByPage(TSetInfo setInfo);
	
	List<TSetInfo> selectTotPackingCartonlist(TSetInfo setInfo);
	
	TSetInfo getSetInfoBysetCode(TSetInfo setInfo);
}
