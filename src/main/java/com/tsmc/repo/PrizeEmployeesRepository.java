package com.tsmc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tsmc.entity.PrizeEmployees;

public interface PrizeEmployeesRepository extends JpaRepository<PrizeEmployees, String>{
	
	public PrizeEmployees findByActyIdAndPrizeId(String actyId, String prizeId);

}
