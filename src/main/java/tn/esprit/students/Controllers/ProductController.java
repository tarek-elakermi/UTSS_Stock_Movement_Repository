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
import tn.esprit.students.Models.SequenceGeneretorService;
import tn.esprit.students.Models.User;
import tn.esprit.students.Services.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl serviceProduct;
	
	@Autowired
	private SequenceGeneretorService service;
	
	
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
		product.setIdProduct(String.valueOf(service.getSequenceNumber(User.SEQUENCE_NAME)));
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
	
	
	@PostMapping(value = "/affectUnderCategoryToProduct/{idProduct}/{idUnderCategory}")
	public void AffectProductToUnderCategory(@PathVariable("idProduct") String idProduct ,
			@PathVariable("idUnderCategory") String idUnderCategory) {
		serviceProduct.affectUnderCtegorytToProduct(idProduct, idUnderCategory);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
