package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class T_PackNum_Bind implements Serializable {

	private static final long serialVersionUID = -1960430607624522491L;

	private String handlingUnitID;

	private String dispPackNum;
	
	private int qty;
	
	private int orderNo;
	
	private String boxNo;
	
	private String styleNo;
	
	private int isDel;
	
	private String isUserd;

	public String getIsUserd() {
		return isUserd;
	}

	public void setIsUserd(String isUserd) {
		this.isUserd = isUserd;
	}

	public String getHandlingUnitID() {
		return handlingUnitID;
	}

	public void setHandlingUnitID(String handlingUnitID) {
		this.handlingUnitID = handlingUnitID;
	}

	public String getDispPackNum() {
		return dispPackNum;
	}

	public void setDispPackNum(String dispPackNum) {
		this.dispPackNum = dispPackNum;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getBoxNo() {
		return boxNo;
	}

	public void setBoxNo(String boxNo) {
		this.boxNo = boxNo;
	}

	public String getStyleNo() {
		return styleNo;
	}

	public void setStyleNo(String styleNo) {
		this.styleNo = styleNo;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
}
