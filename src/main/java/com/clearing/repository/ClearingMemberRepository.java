package com.clearing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.clearing.entity.ClearingMember;

public interface ClearingMemberRepository extends JpaRepository<ClearingMember, Integer> {

}
