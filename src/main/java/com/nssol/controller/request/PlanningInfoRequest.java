package com.nssol.controller.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import com.nssol.common.model.PageUtils;

public class PlanningInfoRequest extends PageUtils implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7460430508668669350L;
	
	private String planningNum;
	
	private String orderNo;
	
	private String dONo;
	
	private String setCode;
	
	private String shiptoPortCode;
	
	private String shiptoPort;
	
	private String warehouse;
	
	private int planQty;
	
	private String brand;
	
	private String proLine;
	
	
	private BigDecimal qtyPcs;
	
	private int sort;
	
	private String sampleCode;
	
    private String itemCode;
    
    private int isScaned;
	
	
	public int getPlanQty() {
		return planQty;
	}

	public void setPlanQty(int planQty) {
		this.planQty = planQty;
	}

	public int getIsScaned() {
		return isScaned;
	}

	public void setIsScaned(int isScaned) {
		this.isScaned = isScaned;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public String getSampleCode() {
		return sampleCode;
	}

	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}

	public String getplanningNum() {
		return planningNum;
	}

	public void setplanningNum(String planningNum) {
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

	public String getShiptoPortCode() {
		return shiptoPortCode;
	}

	public void setShiptoPortCode(String shiptoPortCode) {
		this.shiptoPortCode = shiptoPortCode;
	}

	public String getShiptoPort() {
		return shiptoPort;
	}

	public void setShiptoPort(String shiptoPort) {
		this.shiptoPort = shiptoPort;
	}

	public String getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(String warehouse) {
		this.warehouse = warehouse;
	}

	public int getQty() {
		return planQty;
	}

	public void setQty(int qty) {
		this.planQty = qty;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String itemBrand) {
		this.brand = itemBrand;
	}

	public String getProLine() {
		return proLine;
	}

	public void setProLine(String proLine) {
		this.proLine = proLine;
	}

	public BigDecimal getQtyPcs() {
		return qtyPcs;
	}

	public void setQtyPcs(BigDecimal qtyPcs) {
		this.qtyPcs = qtyPcs;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
