package com.nssol.dao.master;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.T_OperationalLog;
import com.nssol.model.T_Pack;

@Mapper
public interface TPackDao {
	
	void insertPackInfo(T_Pack tPack);
	
	List<T_Pack> getPackListByPage(T_Pack tPack);
	
	List<T_Pack> selectTotPacklist(T_Pack tPack);
	
	void deletePack(Map<String, Object> map);
	
	void insertPackAndDetail(T_Pack tPack);
	
	T_Pack selectPackPK(T_Pack tPack);
	
	T_Pack getPackIsExistByHandlingUnitID(T_Pack tPack);
}
