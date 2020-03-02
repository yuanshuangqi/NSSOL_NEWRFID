package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class T_ProductionLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7460430508668669350L;
	
	private String iD;
	
	private String proLineCode;
	
	private String proLineName;
	
	private String isDel;

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getProLineCode() {
		return proLineCode;
	}

	public void setProLineCode(String proLineCode) {
		this.proLineCode = proLineCode;
	}

	public String getProLineName() {
		return proLineName;
	}

	public void setProLineName(String proLineName) {
		this.proLineName = proLineName;
	}

	public String getIsDel() {
		return isDel;
	}

	public void setIsDel(String isDel) {
		this.isDel = isDel;
	}

}
