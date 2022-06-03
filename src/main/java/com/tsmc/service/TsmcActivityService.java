package com.tsmc.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.tsmc.dto.ActivityRequest;
import com.tsmc.entity.TsmcActivity;
import com.tsmc.repo.TsmcActivityRepository;


@Service
public class TsmcActivityService {
	private static final Logger logger = LoggerFactory.getLogger(TsmcActivityService.class);
	
	private HttpHeaders headers;

	@Autowired
	private TsmcActivityRepository activityRepo;
	
	@PostConstruct
	private void instantiate() {
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	}
	
	public List<TsmcActivity> fetchTsmcActivity(final String activityName, final String year, final String month, final String day) {
		return activityRepo.fetchByActivityNameAndActivityDate(activityName, year, month, day);
	}
	
	public List<TsmcActivity> findByYear(final String year) {
		return activityRepo.findByYear(year);
	}

	public TsmcActivity createTsmcActivity(final ActivityRequest activityReq) {
		TsmcActivity activity = this.convertToEntity(activityReq);
		
		return activityRepo.save(activity);
	} 
	
	private TsmcActivity convertToEntity(final ActivityRequest req) {
		TsmcActivity activity = new TsmcActivity();
		activity.setOid(UUID.randomUUID().toString());
		activity.setActivityName(req.getName());
		activity.setYear(req.getYear());
		activity.setMonth(req.getMonth());
		activity.setDay(req.getDay());
		activity.setUsersCount(req.getUsersCount());
		activity.setPrizeCount(req.getPrizeCount());
		
		return activity;
	}
	

}
