package com.tsmc.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tsmc.dto.PrizeEmployeesRequest;
import com.tsmc.entity.PrizeEmployees;
import com.tsmc.repo.PrizeEmployeesRepository;

@Service
public class PrizeEmployeesService {
	
	@Autowired
	private PrizeEmployeesRepository prizeEmployeesRepo;
	
	public PrizeEmployees findByActyIdAndPrizeId(String actyId, String prizeId) {
		return prizeEmployeesRepo.findByActyIdAndPrizeId(actyId, prizeId);
	}

	public PrizeEmployees createPrizeEmployees(PrizeEmployeesRequest prizeEmployeesReq) {
		PrizeEmployees prizeEmployees = this.convertToEntity(prizeEmployeesReq);
		
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

}
