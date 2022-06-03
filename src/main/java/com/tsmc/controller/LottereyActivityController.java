package com.tsmc.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tsmc.dto.ActivityRequest;
import com.tsmc.entity.TsmcActivity;
import com.tsmc.service.TsmcActivityService;


@RestController
@RequestMapping("/api/v1/lotterys/activity")
public class LottereyActivityController {
	
	private static final Logger logger = LoggerFactory.getLogger(LottereyActivityController.class);	
	
	@Autowired
	private TsmcActivityService  activityService;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<TsmcActivity> fetchTsmcActivity(
			@RequestParam(value="name", required = true) String activityName,
			@RequestParam(value="year", required = true) String year,
			@RequestParam(value="month", required = true) String month,
			@RequestParam(value="day", required = true) String day
			) {
		logger.info("[{}], [{}], [{}], [{}]", activityName, year, month, day);
		return activityService.fetchTsmcActivity(activityName, year, month, day);
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TsmcActivity createTsmcActivity(
			@RequestBody ActivityRequest activityReq
			) {
		logger.info("[{}]",  activityReq);
		return activityService.createTsmcActivity(activityReq);
	}	

}
