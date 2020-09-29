package com.clearing.repository;
import org.springframework.data.repository.CrudRepository;

import com.clearing.entity.ClearingMemberEntity;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface MemberRepository extends CrudRepository<ClearingMemberEntity, Integer> {
    
}