package com.nssol.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class T_Print_Detail_Pass implements Serializable {

	private static final long serialVersionUID = -5938541248639481454L;

    private String labelType;
	
	private String labelBody;

	public String getLabelType() {
		return labelType;
	}

	public void setLabelType(String labelType) {
		this.labelType = labelType;
	}

	public String getLabelBody() {
		return labelBody;
	}

	public void setLabelBody(String labelBody) {
		this.labelBody = labelBody;
	}

}
