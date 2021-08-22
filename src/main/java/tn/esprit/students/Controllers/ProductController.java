package tn.esprit.students.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Services.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl serviceProduct;
	
	ProductRepository pr ;
	
	
	@GetMapping("/AllProducts")
	public List<Product> getAllProducts(){
		List<Product> list = serviceProduct.retrieveAllProducts();
		return list;
	}
	
	@GetMapping("/OneProduct/{idProduct}")
	@ResponseBody
	public Product getOneProduct(@PathVariable("idProduct") String idProduct) {
		
			return serviceProduct.retrieveProduct(idProduct);
		
	}
	
	@PostMapping(value = "/addProduct")
	public Product addProduct(@RequestBody Product product) {
		serviceProduct.addProduct(product);
		return product;
		
	}
	
	@PutMapping(value = "/updateProduct")
	public Product updateProduct(@RequestBody Product product) {
		return serviceProduct.updateProduct(product);
		
	}
	
	@DeleteMapping(value = "/deleteProduct/{idProduct}")
	public void deleteProduct(@PathVariable("idProduct") String idProduct) {
		serviceProduct.deleteProduct(idProduct);
	}
	
	
	
	
	@GetMapping("/retrieve-Product-By-Name/{Product-nameProduct}")
	@ResponseBody
	public Product retrieveDepByName(@PathVariable("Product-nameProduct") String nameproduct) {
	return serviceProduct.GetByName(nameproduct);
	
	}
	
	
	
	
	
	
	
	
	

}
