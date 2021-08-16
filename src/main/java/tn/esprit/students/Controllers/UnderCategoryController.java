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
import tn.esprit.students.Models.SequenceGeneretorService;
import tn.esprit.students.Models.UnderCategory;
import tn.esprit.students.Models.User;
import tn.esprit.students.Services.UnderCategoryImpl;

@RestController
public class UnderCategoryController {
	
	@Autowired
	private UnderCategoryImpl serviceUnderCategory;
	
	@Autowired
	private SequenceGeneretorService service;
	
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
		underCategory.setIdUnderCategory(String.valueOf(service.getSequenceNumber(User.SEQUENCE_NAME)));
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
	
	@PutMapping(value = "/affectProductToUnderCategory/{idUnderCategory}/{idProduct}")
	public void AffectProductToUnderCategory(@PathVariable("idUnderCategory") String idUnderCategory ,
			@PathVariable("idProduct") String idProduct) {
		serviceUnderCategory.affectProductToUnderCtegoryt(idUnderCategory, idProduct);
	}
	
	
	//get UnderCatByName
	@GetMapping(value = "/getUnderCatByName/{nameUnderCategory}")
	public UnderCategory getUnderCategoryBYNAME(@PathVariable("nameUnderCategory") String nameUnderCategory) {
		return serviceUnderCategory.getUnderCategoryByName(nameUnderCategory);
	}
	
	
	
	
	
	

}
