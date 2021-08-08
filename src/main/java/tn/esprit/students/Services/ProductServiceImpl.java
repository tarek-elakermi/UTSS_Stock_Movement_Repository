package tn.esprit.students.Services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Models.UnderCategoryRepository;


@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UnderCategoryRepository underCategoryRepository;
	
	
	private static final Logger L = LogManager.getLogger(ProductServiceImpl.class);


	@Override
	public List<Product> retrieveAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		for (Product product : products) {
			L.info("products +++ :" + product );
		}
		return products;
	}

	@Override
	public Product addProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product updateProduct(Product p) {
		return productRepository.save(p);
	}

	@Override
	public Product retrieveProduct(String idProduct) {
		Product product = productRepository.findById(idProduct).get();
		L.info("product returned +++ :" + product);
		return product;
	}

	@Override
	public void deleteProduct(String idProduct) {
		productRepository.deleteById(idProduct);		
	}

	

}
