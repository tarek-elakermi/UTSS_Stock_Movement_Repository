package tn.esprit.students.Models;



import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import lombok.Data;


@Document
@Data
@Repository
public interface MovementRepository extends MongoRepository<Movement, String> {
	
	List<Movement> findByUserMovements(String userName);
	
	
	
	//List<Movement> getMovementByUser();

	
	
	
	
	
}
