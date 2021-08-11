package tn.esprit.students.Services;

import java.util.List;

import tn.esprit.students.Models.Product;

public interface ProductService {
	
	List<Product> retrieveAllProducts();
	Product addProduct(Product p);
	Product updateProduct(Product p);
	Product retrieveProduct(String idProduct);
	void deleteProduct(String idProduct);
	
	void affectUnderCtegorytToProduct( String idProduct,String idUnderCategory);
	

}
