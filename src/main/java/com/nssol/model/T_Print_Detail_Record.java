package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.nssol.common.model.PageUtils;


public class T_Print_Detail_Record implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855069017401252988L;

	private String printID;
	
	private String printContent;
	
	private String printModel;
	
	private String creater;

	private String modifyer;

	public String getPrintID() {
		return printID;
	}

	public void setPrintID(String printID) {
		this.printID = printID;
	}

	public String getPrintContent() {
		return printContent;
	}

	public void setPrintContent(String printContent) {
		this.printContent = printContent;
	}

	public String getPrintModel() {
		return printModel;
	}

	public void setPrintModel(String printModel) {
		this.printModel = printModel;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}
	
	
}
