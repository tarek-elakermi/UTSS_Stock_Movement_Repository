package tn.esprit.students.Models;






import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Document
@Repository
public interface UnderCategoryRepository extends MongoRepository<UnderCategory, String> {

	
	UnderCategory findByNameUnderCategory(String nameUnderCategory);
	

	
	
	
	

}
