package com.tsmc.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tsmc.entity.PrizeEmployees;

public interface PrizeEmployeesRepository extends JpaRepository<PrizeEmployees, String>{
	
	public Optional<PrizeEmployees> findByActyIdAndPrizeId(String actyId, String prizeId);

}
