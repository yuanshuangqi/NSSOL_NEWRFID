package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.nssol.common.model.PageUtils;

public class T_Pack extends PageUtils  implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

	private String uQInnerPackNum;
	
	private String handlingUnitID;

     private String dispPackNum;

     private String orderNo;

     private String dONo;

     private String setCode;

     private String packType;

     private int qtyPerSet;

     private String proLine;

     private String factory;

     private String workShop;

     private String creater;
     
     private String modifyer;
     
     private String proLineName;
     
     
     private Integer startRecord;
 	private Integer endRecord;
 	
    private String innerPackNum;
    
    private String createTimeStart;
    
    private String createTimeEnd;
    
    private String createTime;
    
    private String brandModel;
 	
    private String comment;
    
    private String planningNum;
    
    private List<T_Pack_Detail> packDetailList;
    
 	public String getHandlingUnitID() {
		return handlingUnitID;
	}

	public void setHandlingUnitID(String handlingUnitID) {
		this.handlingUnitID = handlingUnitID;
	}

	public List<T_Pack_Detail> getPackDetailList() {
		return packDetailList;
	}

	public void setPackDetailList(List<T_Pack_Detail> packDetailList) {
		this.packDetailList = packDetailList;
	}

	public String getPlanningNum() {
		return planningNum;
	}

	public void setPlanningNum(String planningNum) {
		this.planningNum = planningNum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getBrandModel() {
		return brandModel;
	}

	public void setBrandModel(String brandModel) {
		this.brandModel = brandModel;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getInnerPackNum() {
		return innerPackNum;
	}

	public void setInnerPackNum(String innerPackNum) {
		this.innerPackNum = innerPackNum;
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


	public String getProLineName() {
		return proLineName;
	}

	public void setProLineName(String proLineName) {
		this.proLineName = proLineName;
	}

	public String getModifyer() {
		return modifyer;
	}

	public void setModifyer(String modifyer) {
		this.modifyer = modifyer;
	}

	public String getuQInnerPackNum() {
		return uQInnerPackNum;
	}

	public void setuQInnerPackNum(String uQInnerPackNum) {
		this.uQInnerPackNum = uQInnerPackNum;
	}

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

	public String getPackType() {
		return packType;
	}

	public void setPackType(String packType) {
		this.packType = packType;
	}

	public int getQtyPerSet() {
		return qtyPerSet;
	}

	public void setQtyPerSet(int qtyPerSet) {
		this.qtyPerSet = qtyPerSet;
	}

	public String getProLine() {
		return proLine;
	}

	public void setProLine(String proLine) {
		this.proLine = proLine;
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


}
