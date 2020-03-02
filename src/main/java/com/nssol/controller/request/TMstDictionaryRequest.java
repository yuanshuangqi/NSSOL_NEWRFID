package com.nssol.controller.request;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.model.PageUtils;

public class TMstDictionaryRequest implements Serializable {

	private static final long serialVersionUID = 7579890050219013454L;


	private String dicType;


	public String getDicType() {
		return dicType;
	}


	public void setDicType(String dicType) {
		this.dicType = dicType;
	}
	
	
}
