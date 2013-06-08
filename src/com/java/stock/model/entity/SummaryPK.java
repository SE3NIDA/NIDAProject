package com.java.stock.model.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SUMMARY database table.
 * 
 */
@Embeddable
public class SummaryPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="SUM_WA_ID")
	private long sumWaId;

	@Column(name="SUM_PRO_ID")
	private long sumProId;

	public SummaryPK() {
	}
	public long getSumWaId() {
		return this.sumWaId;
	}
	public void setSumWaId(long sumWaId) {
		this.sumWaId = sumWaId;
	}
	public long getSumProId() {
		return this.sumProId;
	}
	public void setSumProId(long sumProId) {
		this.sumProId = sumProId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SummaryPK)) {
			return false;
		}
		SummaryPK castOther = (SummaryPK)other;
		return 
			(this.sumWaId == castOther.sumWaId)
			&& (this.sumProId == castOther.sumProId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.sumWaId ^ (this.sumWaId >>> 32)));
		hash = hash * prime + ((int) (this.sumProId ^ (this.sumProId >>> 32)));
		
		return hash;
	}
}