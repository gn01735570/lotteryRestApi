package com.tsmc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TSMC_ACTY")
public class TsmcActivity {
	
	@Id
	@Column(name = "OID")
	private String oid;
	
	@Column(name = "ACTY_NAME")
	private String activityName;
	
	@Column(name = "YEAR")
	private String year;
	
	@Column(name = "MONTH")
	private String month;	

	@Column(name = "DAY")
	private String day;
	
	@Column(name = "USERS_COUNT")
	private String usersCount;
	
	@Column(name = "PRIZE_COUNT")
	private String prizeCount;

	public String getDay() {
		return day;
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


	public void setDay(String day) {
		this.day = day;
	}

	public String getOid() {
		return oid;
	}

	public void setOid(String oid) {
		this.oid = oid;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
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

}
