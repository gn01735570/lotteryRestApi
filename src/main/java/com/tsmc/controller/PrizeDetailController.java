package com.tsmc.controller;

import java.util.List;
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

import com.tsmc.dto.PrizeDetailRequest;
import com.tsmc.entity.PrizeDetail;
import com.tsmc.service.PrizeDetailService;

@RestController
@RequestMapping("/api/v1/prizes")
public class PrizeDetailController {
private static final Logger logger = LoggerFactory.getLogger(PrizeDetailController.class);	
	
	@Autowired
	private PrizeDetailService  prizeDetailService;
	
	@GetMapping
	@ResponseStatus(value = HttpStatus.OK)
	public List<PrizeDetail> fetchPrizeDetail(
			@RequestParam(value="activityId", required = true) String activityId
			) {
		logger.info("[{}]", activityId);
		return prizeDetailService.fetchPrizeDetail(activityId);
	}
	
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.CREATED)
	public PrizeDetail createPrizeDetail(
			@RequestBody PrizeDetailRequest prizeDetailReq
			) {
		logger.debug("[{}]",  prizeDetailReq.toString());
		return prizeDetailService.createPrizeDetail(prizeDetailReq);
	}	
	
}
