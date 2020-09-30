package com.clearing.repository;
import org.springframework.data.repository.CrudRepository;

import com.clearing.entity.ClearingMemberEntity;




public interface MemberRepository extends CrudRepository<ClearingMemberEntity, Integer> {
    
}