package com.tsmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TSMC_ACTY_PRIZE_DETL")
public class PrizeDetail {
	
	@Id
	@Column(name = "OID")
	private String oid;
	
	
	@Column(name = "ACTY_ID")
	private String actyId;
	
	@Column(name = "PRIZE")
	private String prize;
	
	@Column(name = "QUOTA")
	private Integer quota;
		

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getActyId() {
		return actyId;
	}

	public void setActyId(String actyId) {
		this.actyId = actyId;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	
	

}
