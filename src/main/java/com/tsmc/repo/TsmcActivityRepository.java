package com.tsmc.repo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tsmc.entity.TsmcActivity;


public interface TsmcActivityRepository extends JpaRepository<TsmcActivity, String>{	
	
	static final String SQL_QUERY_ACTY = ""
	+ " SELECT * \r\n"
	+ " FROM TSMC_ACTY \r\n" 
	+ " WHERE ACTY_NAME = (:activityName) \r\n"
	+ " AND YEAR = (:year) \r\n"
	+ " AND MONTH = (:month) \r\n"
	+ " AND DAY = (:day) \r\n";
	
	@Query(value=SQL_QUERY_ACTY, nativeQuery=true)
	public Optional<TsmcActivity> fetchByActivityNameAndActivityDate(
			@Param("activityName") String activityName,
			@Param("year") String year,
			@Param("month") String month,
			@Param("day") String day
			);
	
	public List<TsmcActivity> findByYear(String year);

}
