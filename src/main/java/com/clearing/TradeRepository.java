package com.clearing;
import org.springframework.data.repository.CrudRepository;

// import com.clearing.Trade;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface TradeRepository extends CrudRepository<Trade, Integer> {
    
}