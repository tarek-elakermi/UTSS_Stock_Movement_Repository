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


import tn.esprit.students.Models.UnderCategory;
import tn.esprit.students.Services.UnderCategoryImpl;

@RestController
public class UnderCategoryController {
	
	@Autowired
	private UnderCategoryImpl serviceUnderCategory;
	
	@GetMapping("/AllUnderCategory")
	public List<UnderCategory> getAllCategories(){
		List<UnderCategory> list = serviceUnderCategory.retrieveAllUnderCategories();
		return list;
	}
	
	@GetMapping("/OneUnderCategory/{idUnderCategory}")
	@ResponseBody
	public UnderCategory getOneUnderCategory(@PathVariable("idUnderCategory") String idUnderCateString) {
		
			return serviceUnderCategory.retrieveUnderCategory(idUnderCateString);
		
	}
	
	@PostMapping(value = "/addUnderCategory")
	public UnderCategory addUnderCategory(@RequestBody UnderCategory underCategory) {
		serviceUnderCategory.addUnderCategory(underCategory);
		return underCategory;
		
	}
	
	@PutMapping(value = "/updateUnderCategory")
	public UnderCategory updateUnderCategory(@RequestBody UnderCategory underCategory) {
		return serviceUnderCategory.updateUnderCategory(underCategory);
		
	}
	
	@DeleteMapping(value = "/deleteUnderCategory/{idUnderCategory}")
	public void deleteUnderCategory(@PathVariable("idUnderCategory") String idUnderCateString) {
		serviceUnderCategory.deleteUnderCategory(idUnderCateString);
	}
	
	
	
	@PutMapping("/affect-product-to-under-category/{Idp}/{Iduc}")
	public void affecterProduitARayon(@PathVariable(value = "Idp") String idProduct,
			@PathVariable(value = "Iduc") String idUnderCategory) {
		serviceUnderCategory.assignProductToUnderCategory(idUnderCategory, idProduct);
		
	}
	
	

}
