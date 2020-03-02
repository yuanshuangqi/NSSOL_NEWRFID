package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

public class PlanningData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7460430508668669350L;
	
	private String iD;
	
	private String orderNo;
	
	private String dONo;
	
	private String setCode;
	
	private String shiptoPortCode;
	
	private String shiptoPort;
	
	private String warehouse;
	
	private BigDecimal qty;
	
	private String itemBrand;
	
	private String proLine;
	
	private String scanSort;
	
	private int transType;
	
	private BigDecimal qtyPcs;
	
	private String sampleCode;
	
	private String itemCode;
	
	private List<T_Planning_Detail> lsPlanningDetail;

	public String getiD() {
		return iD;
	}

	public void setiD(String iD) {
		this.iD = iD;
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

	public BigDecimal getQty() {
		return qty;
	}

	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}

	public String getItemBrand() {
		return itemBrand;
	}

	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}

	public String getProLine() {
		return proLine;
	}

	public void setProLine(String proLine) {
		this.proLine = proLine;
	}

	public String getScanSort() {
		return scanSort;
	}

	public void setScanSort(String scanSort) {
		this.scanSort = scanSort;
	}

	public int getTransType() {
		return transType;
	}

	public void setTransType(int transType) {
		this.transType = transType;
	}

	public BigDecimal getQtyPcs() {
		return qtyPcs;
	}

	public void setQtyPcs(BigDecimal qtyPcs) {
		this.qtyPcs = qtyPcs;
	}

	public String getSampleCode() {
		return sampleCode;
	}

	public void setSampleCode(String sampleCode) {
		this.sampleCode = sampleCode;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public List<T_Planning_Detail> getLsPlanningDetail() {
		return lsPlanningDetail;
	}

	public void setLsPlanningDetail(List<T_Planning_Detail> lsPlanningDetail) {
		this.lsPlanningDetail = lsPlanningDetail;
	}
	
}
