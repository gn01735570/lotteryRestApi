package com.tsmc.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tsmc.entity.PrizeDetail;

public interface PrizeDetailRepository extends JpaRepository<PrizeDetail, String>{
	
	public List<PrizeDetail> findByActyId(String actyId);
	
}
