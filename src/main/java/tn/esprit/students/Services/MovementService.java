package tn.esprit.students.Services;

import java.util.List;


import tn.esprit.students.Models.Movement;
import tn.esprit.students.Models.Product;

public interface MovementService {
	
	

	List<Movement> retrieveAllMovement();
	Movement addMovement(Movement m);
	Movement updateMovement(Movement m);
	Movement retrieveMovement(String idMovement);
	void deleteMovement(String idMovement);
	
	
	void affectMovementToUser(String idMovement , String idUser);
	
	void affectMovementToProduct(String idMovement , String idProduct);
	
	//List<Product> getProductByMovementinUser(String userName);
	

}
