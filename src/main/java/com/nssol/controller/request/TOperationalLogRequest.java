package com.nssol.controller.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.model.PageUtils;
import com.nssol.model.T_Pack;

public class TOperationalLogRequest  extends PageUtils  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7460430508668669350L;
	
    private String iD;
	
	private String dONo;
	
	private String setCode;
	
	private Date optTime;
	
    private String optType;

    private String optContent;
    
    private String creater;
    
    private Date createTime;
    
    private String modifyer;
    
    private Date modifyTime;
    
    private String orderNo;
    
    private int scanedQty;
    
    private String proLine;
	
    private String optError;

    private T_Pack packInfo;
    
    private String planningNum;

    public String getPlanningNum() {
		return planningNum;
	}

	public void setPlanningNum(String planningNum) {
		this.planningNum = planningNum;
	}

	public void setProLine(String proLine) {
		this.proLine = proLine;
	}

	public T_Pack getPackInfo() {
	return packInfo;
    }

    public void setPackInfo(T_Pack packInfo) {
	this.packInfo = packInfo;
    }
	
	public String getOptError() {
		return optError;
	}

	public void setOptError(String optError) {
		this.optError = optError;
	}
	public String getProLine() {
		return proLine;
	}
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getScanedQty() {
		return scanedQty;
	}

	public void setScanedQty(int scanedQty) {
		this.scanedQty = scanedQty;
	}

	public int getScanedQty_Fail() {
		return scanedQty_Fail;
	}

	public void setScanedQty_Fail(int scanedQty_Fail) {
		this.scanedQty_Fail = scanedQty_Fail;
	}

	public int getScanedQty_Subtract() {
		return scanedQty_Subtract;
	}

	public void setScanedQty_Subtract(int scanedQty_Subtract) {
		this.scanedQty_Subtract = scanedQty_Subtract;
	}

	public int getScanedQty_Add() {
		return scanedQty_Add;
	}

	public void setScanedQty_Add(int scanedQty_Add) {
		this.scanedQty_Add = scanedQty_Add;
	}

	private int scanedQty_Fail;
	
	private int scanedQty_Subtract;
	
	private int scanedQty_Add;
	

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
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

	public Date getOptTime() {
		return optTime;
	}

	public void setOptTime(Date optTime) {
		this.optTime = optTime;
	}

	public String getOptType() {
		return optType;
	}

	public void setOptType(String optType) {
		this.optType = optType;
	}

	public String getOptContent() {
		return optContent;
	}

	public void setOptContent(String optContent) {
		this.optContent = optContent;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
