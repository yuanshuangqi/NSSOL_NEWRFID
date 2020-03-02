package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class T_Planning_Detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5980736646536686114L;
	
	private String orderNo;
	
	private String dONo;
	
	private String setCode;
	
	private String colorCode;
	
	private String color;
	
	private String patternDimensionCode;
	
	private String sizeCode;
	
	private String size;
	
	private BigDecimal qtyPerSet;
	
	private int isDel;
	
	private String sKUCode;
	
	private String creater;

	private Timestamp createTime;

	private String modifyer;

	private Timestamp modifyTime;
	
	private String planningNum;

	public String getPlanningNum() {
		return planningNum;
	}

	public void setPlanningNum(String planningNum) {
		this.planningNum = planningNum;
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

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPatternDimensionCode() {
		return patternDimensionCode;
	}

	public void setPatternDimensionCode(String patternDimensionCode) {
		this.patternDimensionCode = patternDimensionCode;
	}

	public String getSizeCode() {
		return sizeCode;
	}

	public void setSizeCode(String sizeCode) {
		this.sizeCode = sizeCode;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public BigDecimal getQtyPerSet() {
		return qtyPerSet;
	}

	public void setQtyPerSet(BigDecimal qtyPerSet) {
		this.qtyPerSet = qtyPerSet;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getsKUCode() {
		return sKUCode;
	}

	public void setsKUCode(String sKUCode) {
		this.sKUCode = sKUCode;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
