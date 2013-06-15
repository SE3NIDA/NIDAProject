package com.java.stock.common.util;

import java.io.Serializable;
import java.util.Date;

public class SuppliersBean  implements Serializable {  
	
	
	private static final long serialVersionUID = 1L;
	public String SUP_ID;
	public String SUP_FNAME;
	public String SUP_ADDR;
	public String SUP_TEL;
	public String SUP_POSITION;
	public String SUP_REMARK;
	
	public SuppliersBean(String sup_id,String sup_fname,String sup_addr
			,String sup_tel,String sup_position,String sup_remark){
		this.SUP_ID = sup_id;
		this.SUP_FNAME = sup_fname;
		this.SUP_ADDR = sup_addr;
		this.SUP_TEL = sup_tel;
		this.SUP_POSITION = sup_position;
		this.SUP_REMARK = sup_remark;
		
	}

	public String getSUP_ID() {
		return SUP_ID;
	}

	public void setSUP_ID(String sUP_ID) {
		SUP_ID = sUP_ID;
	}

	public String getSUP_FNAME() {
		return SUP_FNAME;
	}

	public void setSUP_FNAME(String sUP_FNAME) {
		SUP_FNAME = sUP_FNAME;
	}

	public String getSUP_ADDR() {
		return SUP_ADDR;
	}

	public void setSUP_ADDR(String sUP_ADDR) {
		SUP_ADDR = sUP_ADDR;
	}

	public String getSUP_TEL() {
		return SUP_TEL;
	}

	public void setSUP_TEL(String sUP_TEL) {
		SUP_TEL = sUP_TEL;
	}

	public String getSUP_POSITION() {
		return SUP_POSITION;
	}

	public void setSUP_POSITION(String sUP_POSITION) {
		SUP_POSITION = sUP_POSITION;
	}

	public String getSUP_REMARK() {
		return SUP_REMARK;
	}

	public void setSUP_REMARK(String sUP_REMARK) {
		SUP_REMARK = sUP_REMARK;
	}

	
	
	
	
}
