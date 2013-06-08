package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the RECIVE_PRODUCT database table.
 * 
 */
@Embeddable
public class ReciveProductPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="REC_BUY_ID")
	private long recBuyId;

	@Column(name="REC_PRO_ID")
	private long recProId;

	public ReciveProductPK() {
	}
	public long getRecBuyId() {
		return this.recBuyId;
	}
	public void setRecBuyId(long recBuyId) {
		this.recBuyId = recBuyId;
	}
	public long getRecProId() {
		return this.recProId;
	}
	public void setRecProId(long recProId) {
		this.recProId = recProId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ReciveProductPK)) {
			return false;
		}
		ReciveProductPK castOther = (ReciveProductPK)other;
		return 
			(this.recBuyId == castOther.recBuyId)
			&& (this.recProId == castOther.recProId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.recBuyId ^ (this.recBuyId >>> 32)));
		hash = hash * prime + ((int) (this.recProId ^ (this.recProId >>> 32)));
		
		return hash;
	}
}