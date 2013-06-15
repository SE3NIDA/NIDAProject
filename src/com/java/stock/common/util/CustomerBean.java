package com.java.stock.common.util;

import java.io.Serializable;
import java.util.Date;

public class CustomerBean  implements Serializable {  
	
	
	private static final long serialVersionUID = 1L;
	public String CUS_ID;
	public String CUS_FNAME;
	public String CUS_LNAME;
	public String CUS_ADDR;
	public String CUS_EMAIL;
	public String CUS_TEL;
	public String CUS_POSITION;
	public String CUS_REMARK;
	
	public CustomerBean(String CUS_ID, String CUS_LNAME, String CUS_FNAME, String CUS_ADDR, String CUS_TEL, String CUS_EMAIL, String CUS_POSITION, String CUS_REMARK)
	{
		this.CUS_ID = CUS_ID;
		this.CUS_FNAME = CUS_FNAME;
		this.CUS_LNAME = CUS_LNAME;
		this.CUS_ADDR = CUS_ADDR;
		this.CUS_EMAIL = CUS_EMAIL;
		this.CUS_TEL = CUS_TEL;
		this.CUS_POSITION = CUS_POSITION;
		this.CUS_REMARK = CUS_REMARK;
		
	}
	public String getCUS_ID() {
		return CUS_ID;
	}
	public void setCUS_ID(String cUS_ID) {
		CUS_ID = cUS_ID;
	}
	public String getCUS_FNAME() {
		return CUS_FNAME;
	}
	public void setCUS_FNAME(String cUS_FNAME) {
		CUS_FNAME = cUS_FNAME;
	}
	public String getCUS_LNAME() {
		return CUS_LNAME;
	}
	public void setCUS_LNAME(String cUS_LNAME) {
		CUS_LNAME = cUS_LNAME;
	}
	public String getCUS_ADDR() {
		return CUS_ADDR;
	}
	public void setCUS_ADDR(String cUS_ADDR) {
		CUS_ADDR = cUS_ADDR;
	}
	public String getCUS_EMAIL() {
		return CUS_EMAIL;
	}
	public void setCUS_EMAIL(String cUS_EMAIL) {
		CUS_EMAIL = cUS_EMAIL;
	}
	public String getCUS_TEL() {
		return CUS_TEL;
	}
	public void setSET_TEL(String cUS_TEL) {
		CUS_TEL = cUS_TEL;
	}
	public String getCUS_POSITION() {
		return CUS_POSITION;
	}
	public void setCUS_POSITION(String cUS_POSITION) {
		CUS_POSITION = cUS_POSITION;
	}
	public String getCUS_REMARK() {
		return CUS_REMARK;
	}
	public void setCUS_REMARK(String cUS_REMARK) {
		CUS_REMARK = cUS_REMARK;
	}
	
	
	
}
