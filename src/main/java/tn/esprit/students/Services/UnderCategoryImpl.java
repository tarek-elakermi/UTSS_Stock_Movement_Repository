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
	public void affectProductToUnderCtegoryt(String idUnderCategory, String idProduct) {
		List<Product> products = new ArrayList<>();
		Product product = productRepository.findById(idProduct).get();
		UnderCategory underCategory = underCategoryRepository.findById(idUnderCategory).get();
		products.add(product);
		serviceProduct.affectUnderCtegorytToProduct(idProduct, idUnderCategory);
		underCategory.setUnderProducts(products);
		underCategoryRepository.save(underCategory);
		
	}

	

}
