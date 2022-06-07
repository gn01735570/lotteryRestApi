package com.tsmc.dto;

public class ActivityRequest {	
	
	private String name;
	
	private String year;
	
	private String month;
	
	private String day;
	
	private String usersCount;
	
	private String prizeCount;
	
	private String randomList;
	
	private String currentIndex;
	
	
	public ActivityRequest(String name, String year, String month, String day, String usersCount, String prizeCount,
			String randomList, String currentIndex) {
		super();
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.usersCount = usersCount;
		this.prizeCount = prizeCount;
		this.randomList = randomList;
		this.currentIndex = currentIndex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getUsersCount() {
		return usersCount;
	}

	public void setUsersCount(String usersCount) {
		this.usersCount = usersCount;
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

	public String getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(String currentIndex) {
		this.currentIndex = currentIndex;
	}

	@Override
	public String toString() {
		return "ActivityRequest [name=" + name + ", year=" + year + ", month=" + month + ", day=" + day
				+ ", usersCount=" + usersCount + ", prizeCount=" + prizeCount + ", randomList=" + randomList
				+ ", currentIndex=" + currentIndex + "]";
	}
	
	

	
}
