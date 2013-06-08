package com.java.stock.common.util;

import java.io.Serializable;
import java.util.Date;

public class WharehouseBean implements Serializable {  
	
	private String  id;
	private String waName;
	private String waLocate;
	private String waTel;
	private String waEmail;
	private String waStatus;
	private Date creatDate;
	private Date upDate;
	private String upBy;
	
	
	public WharehouseBean(String  id, String waName, String waLocate,String waTel, String waEmail, String waStatus,Date creatDate,Date upDate,String upBy){
		this.id = id;
		this.waName = waName;
		this.waLocate = waLocate;
		this.waTel = waTel;
		this.waEmail = waEmail;
		this.waStatus = waStatus;
		this.creatDate = creatDate;
		this.upDate = upDate;
		this.upBy = upBy;
	}
	
	public boolean equals(Object obj)
	  {
	    if (obj == null) {
	      return false;
	    }
	    if (!(obj instanceof WharehouseBean)) {
	      return false;
	    }
	    WharehouseBean compare = (WharehouseBean)obj;

	    return compare.id.equals(this.id);
	  }

	public int hashCode()
	  {
	    int hash = 1;

	    return hash * 31 + this.id.hashCode();
	  }
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWaName() {
		return waName;
	}
	public void setWaName(String waName) {
		this.waName = waName;
	}
	public String getWaLocate() {
		return waLocate;
	}
	public void setWaLocate(String waLocate) {
		this.waLocate = waLocate;
	}
	public String getWaTel() {
		return waTel;
	}
	public void setWaTel(String waTel) {
		this.waTel = waTel;
	}
	public String getWaEmail() {
		return waEmail;
	}
	public void setWaEmail(String waEmail) {
		this.waEmail = waEmail;
	}
	public String getWaStatus() {
		return waStatus;
	}
	public void setWaStatus(String waStatus) {
		this.waStatus = waStatus;
	}
	public Date getCreatDate() {
		return creatDate;
	}
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	public Date getUpDate() {
		return upDate;
	}
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
	public String getUpBy() {
		return upBy;
	}
	public void setUpBy(String upBy) {
		this.upBy = upBy;
	}
	
	
	

}
