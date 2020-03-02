package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.nssol.common.model.PageUtils;


public class T_Print_Record implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855069017401252988L;

	private String iD;
	
	private String planningNum;
	
	private String dONo;
	
	private String setCode;
	
	private String dispPackNum;

	private Long seqNum;
	
	private String proLine;
	
	private String newFlg;
	
	private int printNum;
	
	private String retReault;
	
	private int isDel;
	
	private String creater;

	private String modifyer;

	private List<T_Print_Detail_Record> printDetailList;

	public String getRetReault() {
		return retReault;
	}

	public void setRetReault(String retReault) {
		this.retReault = retReault;
	}

	public List<T_Print_Detail_Record> getPrintDetailList() {
		return printDetailList;
	}

	public void setPrintDetailList(List<T_Print_Detail_Record> printDetailList) {
		this.printDetailList = printDetailList;
	}

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
	}

	public String getPlanningNum() {
		return planningNum;
	}

	public void setPlanningNum(String planningNum) {
		this.planningNum = planningNum;
	}

	public String getdONo() {
		return dONo;
	}

	public void setdONo(String dONo) {
		this.dONo = dONo;
	}

	public String getSetCode() {
		return setCode;
	}

	public void setSetCode(String setCode) {
		this.setCode = setCode;
	}

	public String getDispPackNum() {
		return dispPackNum;
	}

	public void setDispPackNum(String dispPackNum) {
		this.dispPackNum = dispPackNum;
	}

	public Long getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(Long seqNum) {
		this.seqNum = seqNum;
	}

	public String getProLine() {
		return proLine;
	}

	public void setProLine(String proLine) {
		this.proLine = proLine;
	}

	public String getNewFlg() {
		return newFlg;
	}

	public void setNewFlg(String newFlg) {
		this.newFlg = newFlg;
	}

	public int getPrintNum() {
		return printNum;
	}

	public void setPrintNum(int printNum) {
		this.printNum = printNum;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
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
}
