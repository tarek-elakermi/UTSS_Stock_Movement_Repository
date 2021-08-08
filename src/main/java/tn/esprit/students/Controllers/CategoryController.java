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

import tn.esprit.students.Models.Category;
import tn.esprit.students.Services.CategoryServiceImpl;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryServiceImpl serviceCategory;
	
	
	@GetMapping("/AllCategories")
	public List<Category> getAllCategories(){
		List<Category> list = serviceCategory.retrieveAllCategories();
		return list;
	}

	
	@GetMapping("/OneCategory/{idCategory}")
	@ResponseBody
	public Category getOneCategory(@PathVariable("idCategory") String idCateString) {
		
			return serviceCategory.retrieveCategory(idCateString);
		
	}
	
	
	@PostMapping(value = "/addCategory")
	public Category addCategory(@RequestBody Category category) {
		serviceCategory.addCategory(category);
		return category;
		
	}
	
	@PutMapping(value = "/updateCategory")
	public Category updateCategory(@RequestBody Category category) {
		return serviceCategory.updateCategory(category);
		
	}
	
	@DeleteMapping(value = "/deleteCategory/{idCategory}")
	public void deleteCategory(@PathVariable("idCategory") String idCateString) {
		serviceCategory.deleteCategory(idCateString);
	}
	
	
	
	
	
	
	
	
	
	
	

}
