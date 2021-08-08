package tn.esprit.students.Services;

import java.util.List;

import tn.esprit.students.Models.Movement;

public interface MovementService {
	
	

	List<Movement> retrieveAllMovement();
	Movement addMovement(Movement m);
	Movement updateMovement(Movement m);
	Movement retrieveMovement(String idMovement);
	void deleteMovement(String idMovement);

}
