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

import tn.esprit.students.Models.Stock;
import tn.esprit.students.Models.Store;
import tn.esprit.students.Services.StoreServiceImpl;

@RestController
public class StoreController {
	
	@Autowired
	private StoreServiceImpl serviceStore;
	
	@GetMapping("/AllStores")
	public List<Store> getAllStores(){
		List<Store> list = serviceStore.retrieveAllStore();
		return list;
	}
	
	

	@GetMapping("/OneStore/{idStore}")
	@ResponseBody
	public Store getOneStore(@PathVariable("idStore") String idStore) {
		
			return serviceStore.retrieveStore(idStore);
		
	}
	
	@PostMapping(value = "/addStore")
	public Store addStore(@RequestBody Store store) {
		serviceStore.addStore(store);
		return store;
		
	}
	
	@PutMapping(value = "/updateStore")
	public Store updateStore(@RequestBody Store store) {
		return serviceStore.updateStore(store);
		
	}
	
	@DeleteMapping(value = "/deleteStore/{idStore}")
	public void deleteStore(@PathVariable("idStore") String idStore) {
		serviceStore.deleteStore(idStore);
	}
	
	
	
	
	

}
