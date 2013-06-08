package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the BUYS_DETAIL database table.
 * 
 */
@Embeddable
public class BuysDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="BUYD_PRO_ID")
	private long buydProId;

	@Column(name="BUYD_BUY_ID")
	private long buydBuyId;

	public BuysDetailPK() {
	}
	public long getBuydProId() {
		return this.buydProId;
	}
	public void setBuydProId(long buydProId) {
		this.buydProId = buydProId;
	}
	public long getBuydBuyId() {
		return this.buydBuyId;
	}
	public void setBuydBuyId(long buydBuyId) {
		this.buydBuyId = buydBuyId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof BuysDetailPK)) {
			return false;
		}
		BuysDetailPK castOther = (BuysDetailPK)other;
		return 
			(this.buydProId == castOther.buydProId)
			&& (this.buydBuyId == castOther.buydBuyId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.buydProId ^ (this.buydProId >>> 32)));
		hash = hash * prime + ((int) (this.buydBuyId ^ (this.buydBuyId >>> 32)));
		
		return hash;
	}
}