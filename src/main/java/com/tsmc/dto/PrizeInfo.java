package com.tsmc.dto;

public class PrizeInfo {
	
	private String prizeOid;
	
	private String prize;
	
	private String quota;
	
	private String list;

	public PrizeInfo(String prizeOid, String prize, String quota) {
		super();
		this.prizeOid = prizeOid;
		this.prize = prize;
		this.quota = quota;
	}

	public String getPrizeOid() {
		return prizeOid;
	}

	public void setPrizeOid(String prizeOid) {
		this.prizeOid = prizeOid;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getQuota() {
		return quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PrizeInfo [prizeOid=" + prizeOid + ", prize=" + prize + ", quota=" + quota + ", list=" + list + "]";
	}	

}
