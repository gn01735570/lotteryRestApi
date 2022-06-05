package com.tsmc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TSMC_PRIZE_EMPLS")
public class PrizeEmployees {
	
	@Id
	@Column(name = "OID")
	private String oid;	
	
	@Column(name = "ACTY_ID")
	private String actyId;
	
	@Column(name = "PRIZE_ID")
	private String prizeId;
	
	@Column(name = "EMPLS_ID")
	private String emplsId;

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

	public String getPrizeId() {
		return prizeId;
	}

	public void setPrizeId(String prizeId) {
		this.prizeId = prizeId;
	}

	public String getEmplsId() {
		return emplsId;
	}

	public void setEmplsId(String emplsId) {
		this.emplsId = emplsId;
	}	

}
