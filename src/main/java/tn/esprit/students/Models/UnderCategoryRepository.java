package tn.esprit.students.Models;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnderCategoryRepository extends MongoRepository<UnderCategory, String> {
	
	
	

}
