package tn.esprit.students;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import tn.esprit.students.Models.Category;
import tn.esprit.students.Models.CategoryRepository;
import tn.esprit.students.Models.DbSequence;
import tn.esprit.students.Models.Localisation;
import tn.esprit.students.Models.Movement;
import tn.esprit.students.Models.MovementRepository;
import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Models.Stock;
import tn.esprit.students.Models.StockRepository;
import tn.esprit.students.Models.Store;
import tn.esprit.students.Models.StoreRepository;
import tn.esprit.students.Models.TypeMov;
import tn.esprit.students.Models.TypeStock;
import tn.esprit.students.Models.UnderCategory;
import tn.esprit.students.Models.UnderCategoryRepository;
import tn.esprit.students.Models.User;
import tn.esprit.students.Models.UserRepository;


@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private MovementRepository movmentRepository;
	@Autowired
	private ProductRepository produRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private UnderCategoryRepository underCategoryRepository;
	
	
	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return strings -> {
			//userRepository.save(new User("tarek", "elakermi"));
			//categoryRepository.save(new Category("1", "boissons"));
			/*movmentRepository.save(new Movement("1", new Date(), TypeMov.DESTRACTION));
			produRepository.save(new Product("1","gazouza", "hjag", 10, 12, 12, 10, 12, "hakgf"));
			stockRepository.save(new Stock("1", "stock bizerte", TypeStock.Normal_Stock, new Date(), new Date(), new Date(), 12, 12, 12, 12));
			storeRepository.save(new Store("1", "string","ariana"));
			underCategoryRepository.save(new UnderCategory("1", "7lib"));*/
			

			
		
		};
	}

}
