package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class T_Print_Pass implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

    private String line;
	
	private String wo;
	
	private Long xh;
	
	private int num;
	
	private String type;
	
	List<T_Print_Detail_Pass> detail;

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getWo() {
		return wo;
	}

	public void setWo(String wo) {
		this.wo = wo;
	}

	public Long getXh() {
		return xh;
	}

	public void setXh(Long xh) {
		this.xh = xh;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<T_Print_Detail_Pass> getDetail() {
		return detail;
	}

	public void setDetail(List<T_Print_Detail_Pass> detail) {
		this.detail = detail;
	}
	

}
