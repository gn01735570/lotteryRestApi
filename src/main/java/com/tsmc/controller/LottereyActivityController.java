package com.tsmc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
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
import org.springframework.web.client.HttpClientErrorException;

import com.tsmc.dto.ActivityRequest;
import com.tsmc.dto.ActivityResponse;
import com.tsmc.entity.TsmcActivity;
import com.tsmc.service.TsmcActivityService;


@RestController
@RequestMapping("/api/v1/lotterys/activity")
public class LottereyActivityController {
	
	private static final Logger logger = LoggerFactory.getLogger(LottereyActivityController.class);	
	
	@Autowired
	private TsmcActivityService  activityService;
	
	@GetMapping("/list")
	@ResponseStatus(value = HttpStatus.OK)
	public List<ActivityResponse> fetchTsmcActivityList (
			) {
	    return activityService.fetchTsmcActivityList();	
	}
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public HashMap<String, Object> fetchTsmcActivity (
			@RequestParam(value="activityOid", required = true) String activityOid
			) {
		logger.info("[{}]",activityOid);
	    return activityService.fetchTsmcActivity(activityOid);	
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public TsmcActivity createTsmcActivity(
			@RequestBody ActivityRequest activityReq
			) {
		logger.debug("[{}]",  activityReq.toString());
		return activityService.createTsmcActivity(activityReq);
	}		
}
