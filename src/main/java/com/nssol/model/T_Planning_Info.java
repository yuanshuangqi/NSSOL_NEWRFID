package com.nssol.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.nssol.common.model.PageUtils;


public class T_Planning_Info extends PageUtils  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855069017401252988L;

	private String orderNo;
	
	private String dONo;
	
	private String setCode;
	
	private int planQty;
	
	private String shiptoPortCode;
	
	private String shiptoPort;
	
	private String warehouse;
	
	private String brand;
	
	private String proLine;
	
	private BigDecimal qtyPcs;
	
	private String planningNum;
	
	private int scanedQty;
	
	private int scanedQty_Fail;
	
	private int scanedQty_Subtract;
	
	private int scanedQty_Add;
	
	private int isScaned;
	
	private String sort;
	
	private int isDel;
	
	private String creater;

	private Date createTime;

	private String modifyer;

	private Date modifyTime;
	
	private String sampleCode;
	
	private String itemCode;
	
	private Integer startRecord;
	private Integer endRecord;
	
	private String packType;
	 	
	
	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public Integer getStartRecord() {
		return startRecord;
	}

	public void setStartRecord(Integer startRecord) {
		this.startRecord = startRecord;
	}

	public Integer getEndRecord() {
		return endRecord;
	}

	public void setEndRecord(Integer endRecord) {
		this.endRecord = endRecord;
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

	private List<T_Planning_Detail> lsPlanningDetail;

	public List<T_Planning_Detail> getLsPlanningDetail() {
		return lsPlanningDetail;
	}

	public void setLsPlanningDetail(List<T_Planning_Detail> lsPlanningDetail) {
		this.lsPlanningDetail = lsPlanningDetail;
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

	public int getPlanQty() {
		return planQty;
	}

	public void setPlanQty(int planQty) {
		this.planQty = planQty;
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

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
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

	public String getPlanningNum() {
		return planningNum;
	}

	public void setPlanningNum(String planningNum) {
		this.planningNum = planningNum;
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

	public int getIsScaned() {
		return isScaned;
	}

	public void setIsScaned(int isScaned) {
		this.isScaned = isScaned;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
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
