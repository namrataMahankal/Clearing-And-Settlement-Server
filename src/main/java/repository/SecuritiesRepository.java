package repository;
import org.springframework.data.repository.CrudRepository;

import entity.Securities;

// import com.clearing.Trade;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface SecuritiesRepository extends CrudRepository<Securities, Integer> {
    
}