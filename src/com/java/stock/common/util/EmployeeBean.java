package com.java.stock.common.util;

import java.io.Serializable;
import java.util.Date;

public class EmployeeBean  implements Serializable {  
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String EMP_ID;
	public String EMP_FNAME;
	public String EMP_LNAME;
	public String EMP_ADDR;
	public String EMP_EMAIL;
	public String EMP_TEL;
	public String EMP_POSITION;
	public double EMP_SALARY;
	public Date EMP_STRDATE;
	public String EMP_STATE;
	public String EMP_USER;
	public String EMP_PASS;
	public String EMP_LEVEL;
	
	public EmployeeBean(String emp_id,String emp_name
			,String emp_lname,String emp_addr,String emp_email
			,String emp_tel,String emp_position,double emp_salary
			,Date emp_strdate,String emp_state, String user, String pass, String level){
		this.EMP_ID = emp_id;
		this.EMP_FNAME = emp_name;
		this.EMP_LNAME = emp_lname;
		this.EMP_ADDR = emp_addr;
		this.EMP_EMAIL = emp_email;
		this.EMP_TEL = emp_tel;
		this.EMP_POSITION = emp_position;
		this.EMP_SALARY = emp_salary;
		this.EMP_STRDATE = emp_strdate;
		this.EMP_STATE = emp_state;
		this.EMP_USER = user;
		this.EMP_PASS = pass;
		this.EMP_LEVEL = level;
		
	}
	public String getEMP_ID() {
		return EMP_ID;
	}
	public void setEMP_ID(String eMP_ID) {
		EMP_ID = eMP_ID;
	}
	public String getEMP_FNAME() {
		return EMP_FNAME;
	}
	public void setEMP_FNAME(String eMP_FNAME) {
		EMP_FNAME = eMP_FNAME;
	}
	public String getEMP_LNAME() {
		return EMP_LNAME;
	}
	public void setEMP_LNAME(String eMP_LNAME) {
		EMP_LNAME = eMP_LNAME;
	}
	public String getEMP_ADDR() {
		return EMP_ADDR;
	}
	public void setEMP_ADDR(String eMP_ADDR) {
		EMP_ADDR = eMP_ADDR;
	}
	public String getEMP_EMAIL() {
		return EMP_EMAIL;
	}
	public void setEMP_EMAIL(String eMP_EMAIL) {
		EMP_EMAIL = eMP_EMAIL;
	}
	public String getEMP_TEL() {
		return EMP_TEL;
	}
	public void setEMP_TEL(String eMP_TEL) {
		EMP_TEL = eMP_TEL;
	}
	public String getEMP_POSITION() {
		return EMP_POSITION;
	}
	public void setEMP_POSITION(String eMP_POSITION) {
		EMP_POSITION = eMP_POSITION;
	}
	public double getEMP_SALARY() {
		return EMP_SALARY;
	}
	public void setEMP_SALARY(double eMP_SALARY) {
		EMP_SALARY = eMP_SALARY;
	}
	public Date getEMP_STRDATE() {
		return EMP_STRDATE;
	}
	public void setEMP_STRDATE(Date eMP_STRDATE) {
		EMP_STRDATE = eMP_STRDATE;
	}
	public String getEMP_STATE() {
		return EMP_STATE;
	}
	public void setEMP_STATE(String eMP_STATE) {
		EMP_STATE = eMP_STATE;
	}
	
	public String getEMP_USER() {
		return EMP_USER;
	}
	public void setEMP_USER(String eMP_USER) {
		EMP_USER = eMP_USER;
	}
	public String getEMP_PASS() {
		return EMP_PASS;
	}
	public void setEMP_PASS(String eMP_PASS) {
		EMP_PASS = eMP_PASS;
	}
	
	public String getEMP_LEVEL() {
		return EMP_LEVEL;
	}
	public void setEMP_LEVEL(String eMP_LEVEL) {
		EMP_LEVEL = eMP_LEVEL;
	}
	public boolean equals(Object obj)
	  {
	    if (obj == null) {
	      return false;
	    }
	    if (!(obj instanceof EmployeeBean)) {
	      return false;
	    }
	    EmployeeBean compare = (EmployeeBean)obj;

	    return compare.EMP_ID.equals(this.EMP_ID);
	  }

	public int hashCode()
	  {
	    int hash = 1;

	    return hash * 31 + this.EMP_ID.hashCode();
	  }
	
}
