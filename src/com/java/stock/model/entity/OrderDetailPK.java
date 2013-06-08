package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the ORDER_DETAIL database table.
 * 
 */
@Embeddable
public class OrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="ORD_PRO_ID")
	private long ordProId;

	@Column(name="ORD_OR_ID")
	private long ordOrId;

	public OrderDetailPK() {
	}
	public long getOrdProId() {
		return this.ordProId;
	}
	public void setOrdProId(long ordProId) {
		this.ordProId = ordProId;
	}
	public long getOrdOrId() {
		return this.ordOrId;
	}
	public void setOrdOrId(long ordOrId) {
		this.ordOrId = ordOrId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderDetailPK)) {
			return false;
		}
		OrderDetailPK castOther = (OrderDetailPK)other;
		return 
			(this.ordProId == castOther.ordProId)
			&& (this.ordOrId == castOther.ordOrId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.ordProId ^ (this.ordProId >>> 32)));
		hash = hash * prime + ((int) (this.ordOrId ^ (this.ordOrId >>> 32)));
		
		return hash;
	}
}