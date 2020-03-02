package com.nssol.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import com.nssol.common.Page;

public class UserModel extends Page implements Serializable{

	private static final long serialVersionUID = 7579890050219013424L;

	private String userId;

	private String userName;
	
	private String realName;

	private String password;
	
	private String tel;
	
	private int isDel;
	
	private String fkRoleCode;
	
	private String roleName;
	
	private String creater;
	
	private Date createTime;
	
	private String modifyer;
	
	private Date modifyTime;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}
	
	public String getFkRoleCode() {
		return fkRoleCode;
	}

	public void setFkRoleCode(String fkRoleCode) {
		this.fkRoleCode = fkRoleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

}
