package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class T_Print_Result implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

	private String result;
	private String msg;
	private String line;
	private String wo;
	private Long xh;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
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
	

}
