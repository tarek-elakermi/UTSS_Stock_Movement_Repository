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

import tn.esprit.students.Models.Movement;
import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.SequenceGeneretorService;
import tn.esprit.students.Models.User;
import tn.esprit.students.Services.MovementServiceImpl;

@RestController
public class MovementController {
	
	@Autowired
	private MovementServiceImpl serviceMovement;
	
	@Autowired
	private SequenceGeneretorService service;
	
	@GetMapping("/AllMovements")
	public List<Movement> getAllMovements(){
		List<Movement> list = serviceMovement.retrieveAllMovement();
		return list;
	}
	
	@GetMapping("/OneMovement/{idMovement}")
	@ResponseBody
	public Movement getOneMovement(@PathVariable("idMovement") String idMovement) {
		
			return serviceMovement.retrieveMovement(idMovement);
		
	}
	
	@PostMapping(value = "/addMovement")
	public Movement addMovement(@RequestBody Movement movement) {
		movement.setIdMovement(String.valueOf(service.getSequenceNumber(User.SEQUENCE_NAME)));
		serviceMovement.addMovement(movement);
		return movement;
		
	}
	
	@PutMapping(value = "/updateMovement")
	public Movement updateMovement(@RequestBody Movement movement) {
		return serviceMovement.updateMovement(movement);
		
	}
	
	@DeleteMapping(value = "/deleteMovement/{idMovement}")
	public void deleteMovement(@PathVariable("idMovement") String idMovement) {
		serviceMovement.deleteMovement(idMovement);
	}
	

	@PutMapping(value = "/affectMovementToUser/{idMovement}/{idUser}")
	public void AffectMovementToUser(@PathVariable("idMovement")String idMovement , @PathVariable("idUser") String idUser) {
		 serviceMovement.affectMovementToUser(idMovement, idUser);
	}
	
	@PutMapping(value = "/affectMovementToProduct/{idMovement}/{idProduct}")
	public void affectMovementToProduct(@PathVariable("idMovement")String idMovement , @PathVariable("idProduct") String idProduct) {
		serviceMovement.affectMovementToProduct(idMovement, idProduct);
	}
	
	/*@GetMapping(value = "/getProductByMovementUser/{userName}")
	public List<Product> getProductByMovement(@PathVariable("userName") String userName){
		return serviceMovement.getProductByMovementinUser(userName);
	}*/
	
	
	
	
	
	

}
