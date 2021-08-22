package tn.esprit.students.Models;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

	
		public Product findByTitleProduct(String titleProduct);
	
	
	

}
