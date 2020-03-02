package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import com.nssol.common.model.PageUtils;

public class T_Pack_Detail extends PageUtils  implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

     private String dispPackNum;

     private String orderNo;

     private String dONo;

     private String setCode;

     private String rFID;

     private String sKUCode;

     private Integer isDel;

     private String factory;

     private String workShop;

     private String creater;
     
     private String modifyer;

	public String getDispPackNum() {
		return dispPackNum;
	}

	public void setDispPackNum(String dispPackNum) {
		this.dispPackNum = dispPackNum;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
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

	public String getrFID() {
		return rFID;
	}

	public void setrFID(String rFID) {
		this.rFID = rFID;
	}

	public String getsKUCode() {
		return sKUCode;
	}

	public void setsKUCode(String sKUCode) {
		this.sKUCode = sKUCode;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public String getWorkShop() {
		return workShop;
	}

	public void setWorkShop(String workShop) {
		this.workShop = workShop;
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
