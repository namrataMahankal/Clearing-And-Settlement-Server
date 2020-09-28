package com.clearing.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clearing.entity.ClearingMemberEntity;
import com.clearing.entity.SecuritiesEntity;
import com.clearing.repository.MapRepo;

@Service
public class MappingServiceImpl{

	@Autowired
	private MapRepo mapRepo;
	
	
	public int getId(String name) {
		List<ClearingMemberEntity> entity = (mapRepo.findByClearingMemberName(name));
		return (entity.get(0)).getClearingMemberId();
	}
	

}
