package tn.esprit.students.Services;




import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Models.UnderCategory;
import tn.esprit.students.Models.UnderCategoryRepository;

@Service
public class UnderCategoryImpl implements UnderCategoryService {
	
	@Autowired
	private UnderCategoryRepository underCategoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductServiceImpl serviceProduct;
	
	List<Product> pr = new ArrayList<>();
	
	
	@Autowired
	public UnderCategoryImpl(UnderCategoryRepository underCategoryRepository, ProductServiceImpl serviceProduct) {
		super();
		this.underCategoryRepository = underCategoryRepository;
		this.serviceProduct = serviceProduct;
	}

	private static final Logger L = LogManager.getLogger(UnderCategoryImpl.class);


	@Override
	public List<UnderCategory> retrieveAllUnderCategories() {
		List<UnderCategory> underCategories = (List<UnderCategory>) underCategoryRepository.findAll();
		for (UnderCategory underCategory : underCategories) {
			L.info("categories +++ :" + underCategory );
		}
		return underCategories;
	}

	@Override
	public UnderCategory addUnderCategory(UnderCategory c) {
		
		c.setUnderProducts(pr);
		return underCategoryRepository.save(c);
	}

	@Override
	public UnderCategory updateUnderCategory(UnderCategory c) {
		return underCategoryRepository.save(c);
	}

	@Override
	public UnderCategory retrieveUnderCategory(String idUnderCategory) {
		UnderCategory underCategory = underCategoryRepository.findById(idUnderCategory).get();
		L.info("underCategory returned +++ :" + underCategory);
		return underCategory;
	}

	@Override
	public void deleteUnderCategory(String idUnderCategory) {
		underCategoryRepository.deleteById(idUnderCategory);
		
	}

	
	@Override
	public void affectProductToUnderCtegoryt(String idUnderCategory, String idProduct){
		Product product = productRepository.findById(idProduct).get();
		UnderCategory underCategory = underCategoryRepository.findById(idUnderCategory).get();
		
			underCategory.getUnderProducts().add(product);
			underCategoryRepository.save(underCategory);	
		
		
		
	}

	@Override
	public UnderCategory getUnderCategoryByName(String nameUnderCategory) {
		UnderCategory underCategory = underCategoryRepository.findByNameUnderCategory(nameUnderCategory);
		return underCategory;
	}

	
	
	@Override
	public int countProduct(String nameUnderCategory) {
		
		UnderCategory underCategory = underCategoryRepository.findByNameUnderCategory(nameUnderCategory);
		int a = underCategory.getUnderProducts().size();
		System.out.println("" + a);
		return a ;
	}

	
	
	

	

}
