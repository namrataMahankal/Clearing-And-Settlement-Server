package repository;
import org.springframework.data.repository.CrudRepository;

import entity.EquitySummary;
import entity.EquitySummaryId;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EquitySummaryRepository extends CrudRepository<EquitySummary, EquitySummaryId> {
    
}