package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.nssol.common.model.PageUtils;

public class TSetInfo extends PageUtils  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 215628844821093319L;
	
	private String orderNo;
	
	private String dONo;

	private String setCode;

	private int quantity;

	private int isDel;

	private String creater;

	private String createTime;
	
	private String modifyer;

	private Timestamp modifyTime;

	private String deleter;

	private Timestamp deleteTime;

	private Timestamp importTime;
	
    private String shiptoPortCode;
	
	private String shiptoPort;
	
	private String warehouse;
	
	private Integer startRecord;
	private Integer endRecord;
	 	
	private Integer scanedQty;
	
	private List<TSetDetail> setDetailList;

	public List<TSetDetail> getSetDetailList() {
		return setDetailList;
	}

	public void setSetDetailList(List<TSetDetail> setDetailList) {
		this.setDetailList = setDetailList;
	}
	
	public Integer getScanedQty() {
		return scanedQty;
	}

	public void setScanedQty(Integer scanedQty) {
		this.scanedQty = scanedQty;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
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

	public String getDeleter() {
		return deleter;
	}

	public void setDeleter(String deleter) {
		this.deleter = deleter;
	}

	public Timestamp getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

	public Timestamp getImportTime() {
		return importTime;
	}

	public void setImportTime(Timestamp importTime) {
		this.importTime = importTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
