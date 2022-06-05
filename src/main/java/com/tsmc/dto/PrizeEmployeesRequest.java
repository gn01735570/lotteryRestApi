package com.tsmc.dto;

public class PrizeEmployeesRequest {

	private String actyId;

	private String prizeId;

	private String emplsId;

	public PrizeEmployeesRequest(String actyId, String prizeId, String emplsId) {
		super();
		this.actyId = actyId;
		this.prizeId = prizeId;
		this.emplsId = emplsId;
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

	@Override
	public String toString() {
		return "PrizeEmployeesRequest [actyId=" + actyId + ", prizeId=" + prizeId + ", emplsId=" + emplsId + "]";
	}		
	
	
}
