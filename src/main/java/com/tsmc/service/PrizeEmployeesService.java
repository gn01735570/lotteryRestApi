package com.tsmc.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsmc.dto.PrizeEmployeesRequest;
import com.tsmc.entity.PrizeEmployees;
import com.tsmc.entity.TsmcActivity;
import com.tsmc.repo.PrizeEmployeesRepository;
import com.tsmc.repo.TsmcActivityRepository;

@Service
public class PrizeEmployeesService {
	
	@Autowired
	private PrizeEmployeesRepository prizeEmployeesRepo;
	
	@Autowired
	private TsmcActivityRepository activityRepo;

	
	public Optional<PrizeEmployees> findByActyIdAndPrizeId(String actyId, String prizeId) {
		return prizeEmployeesRepo.findByActyIdAndPrizeId(actyId, prizeId);
	}

	public PrizeEmployees createPrizeEmployees(PrizeEmployeesRequest prizeEmployeesReq) {
		PrizeEmployees prizeEmployees = this.convertToEntity(prizeEmployeesReq);
		this.saveCurrentIndex(prizeEmployeesReq);
		
		return prizeEmployeesRepo.save(prizeEmployees);		
	}
	
	private PrizeEmployees convertToEntity(final PrizeEmployeesRequest req) {
		PrizeEmployees prizeEmployees = new PrizeEmployees();
		
		prizeEmployees.setOid(UUID.randomUUID().toString());
		prizeEmployees.setActyId(req.getActyId());
		prizeEmployees.setPrizeId(req.getPrizeId());
		prizeEmployees.setEmplsId(req.getEmplsId());
		
		return prizeEmployees;
	}
	
	private void saveCurrentIndex(PrizeEmployeesRequest prizeEmployeesReq) {
		System.out.println("prizeEmployeesReq" + prizeEmployeesReq.toString());
		Integer quota = Integer.valueOf(prizeEmployeesReq.getQuota());
		TsmcActivity activity = activityRepo.findById(prizeEmployeesReq.getActyId()).get();
		Integer nowIndex = Integer.valueOf(activity.getCurrentIndex()) + quota;
		activityRepo.setActivityIndex(activity.getOid(), nowIndex.toString());
	}

}
