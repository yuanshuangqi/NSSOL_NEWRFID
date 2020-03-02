package com.nssol.dao.master;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nssol.model.TSetDetail;

@Mapper
public interface TSetDetailDao {

	List<TSetDetail> getSetDetailList(TSetDetail setDetail);

}
