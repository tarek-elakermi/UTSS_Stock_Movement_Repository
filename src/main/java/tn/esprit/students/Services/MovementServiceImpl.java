package tn.esprit.students.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.students.Models.Movement;
import tn.esprit.students.Models.MovementRepository;
import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Models.Stock;

@Service
public class MovementServiceImpl implements MovementService {
	
	
	@Autowired
	MovementRepository movementRepository;
	
	@Autowired
	ProductRepository pr ;
	
	private static final Logger L = LogManager.getLogger(MovementServiceImpl.class);


	@Override
	public List<Movement> retrieveAllMovement() {
		List<Movement> movements = (List<Movement>) movementRepository.findAll();
		for (Movement movement : movements) {
			L.info("movements +++ :" + movement );
		}
		return movements;
	}

	@Override
	public Movement addMovement(Movement m) {
		return movementRepository.save(m);
	}

	@Override
	public Movement updateMovement(Movement m) {
		return movementRepository.save(m);
	}

	@Override
	public Movement retrieveMovement(String idMovement) {
		Movement movement = movementRepository.findById(idMovement).get();
		L.info("movement returned +++ :" + movement);
		return movement;
	}

	@Override
	public void deleteMovement(String idMovement) {
		movementRepository.deleteById(idMovement);
		
	}
	
	

}
