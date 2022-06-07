package com.tsmc.dto;

import java.util.List;

public class ActivityResponse {
	
	private String activityOid;
	
	private String name;
	
	private String currentIndex;
	
	private List<PrizeInfo> info;
	
	private String prizeCount;
	
	private String randomList;
	
	private String usersCount;
		
	public ActivityResponse(String activityOid) {
		super();
		this.activityOid = activityOid;
	}

	public ActivityResponse(String activityOid, String currentIndex, List<PrizeInfo> info, String prizeCount,
			String randomList, String usersCount) {
		super();
		this.activityOid = activityOid;
		this.currentIndex = currentIndex;
		this.info = info;
		this.prizeCount = prizeCount;
		this.randomList = randomList;
		this.usersCount = usersCount;
	}

	public String getActivityOid() {
		return activityOid;
	}

	public void setActivityOid(String activityOid) {
		this.activityOid = activityOid;
	}
		

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	public List<PrizeInfo> getInfo() {
		return info;
	}

	public void setInfo(List<PrizeInfo> info) {
		this.info = info;
	}

	public String getPrizeCount() {
		return prizeCount;
	}

	public void setPrizeCount(String prizeCount) {
		this.prizeCount = prizeCount;
	}

	public String getRandomList() {
		return randomList;
	}

	public void setRandomList(String randomList) {
		this.randomList = randomList;
	}

	public String getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(String usersCount) {
		this.usersCount = usersCount;
	}

	@Override
	public String toString() {
		return "ActivityResponse [activityOid=" + activityOid + ", name=" + name + ", currentIndex=" + currentIndex
				+ ", info=" + info + ", prizeCount=" + prizeCount + ", randomList=" + randomList + ", usersCount="
				+ usersCount + "]";
	}

}
