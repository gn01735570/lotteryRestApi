package com.tsmc.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsmc.dto.PrizeDetailRequest;
import com.tsmc.entity.PrizeDetail;
import com.tsmc.repo.PrizeDetailRepository;

@Service
public class PrizeDetailService {
	
	@Autowired
	private PrizeDetailRepository prizeDetailRepo;


	public List<PrizeDetail> fetchPrizeDetail(String activityId) {
		return prizeDetailRepo.findByActyId(activityId);
	}

	public PrizeDetail createPrizeDetail(PrizeDetailRequest prizeDetailReq) {
		PrizeDetail prizeDetail = this.convertToEntity(prizeDetailReq);
		
		return prizeDetailRepo.save(prizeDetail);		
	}
	
	private PrizeDetail convertToEntity(final PrizeDetailRequest req) {
		PrizeDetail prizeDetail = new PrizeDetail();
		
		prizeDetail.setOid(UUID.randomUUID().toString());
		prizeDetail.setActyId(req.getActivityId());
		prizeDetail.setPrize(req.getPrize());
		prizeDetail.setQuota(req.getQuota());
		
		return prizeDetail;
	}

}
