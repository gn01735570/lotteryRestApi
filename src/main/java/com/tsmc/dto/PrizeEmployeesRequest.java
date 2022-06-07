package com.tsmc.dto;

public class PrizeEmployeesRequest {

	private String actyId;

	private String prizeId;

	private String emplsId;
	
	private String quota;
	

	public PrizeEmployeesRequest(String actyId, String prizeId, String emplsId, String quota) {
		super();
		this.actyId = actyId;
		this.prizeId = prizeId;
		this.emplsId = emplsId;
		this.quota = quota;
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
		

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	@Override
	public String toString() {
		return "PrizeEmployeesRequest [actyId=" + actyId + ", prizeId=" + prizeId + ", emplsId=" + emplsId
				+ ", currentIndex=" + quota + "]";
	}	
		
}
