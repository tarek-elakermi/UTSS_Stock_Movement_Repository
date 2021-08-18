package tn.esprit.students.Services;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import tn.esprit.students.Models.Movement;
import tn.esprit.students.Models.MovementRepository;
import tn.esprit.students.Models.Product;
import tn.esprit.students.Models.ProductRepository;
import tn.esprit.students.Models.User;
import tn.esprit.students.Models.UserRepository;

@Service
public class MovementServiceImpl implements MovementService {
	
	
	@Autowired
	private MovementRepository movementRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ProductServiceImpl serviceProduct;
	
	@Autowired
	private UserServiceImpl serviceUser;
	
	@SuppressWarnings("unused")
	@Autowired
	private MongoTemplate mongoTemplate;
	
	List<Product> pr = new ArrayList<>();
	
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
		m.setMovementProducts(pr);
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

	@Override
	public void affectMovementToUser(String idMovement, String idUser) {
		User user = userRepository.findById(idUser).get();
		Movement movement = movementRepository.findById(idMovement).get();
		
		movement.setUserMovements(user);
		movementRepository.save(movement);
		
	}

	@Override
	public void affectMovementToProduct(String idMovement, String idProduct) {
		Product product = productRepository.findById(idProduct).get();
		Movement movement = movementRepository.findById(idMovement).get();
		serviceProduct.affectProductToMovement(idProduct, idMovement);
		movement.getMovementProducts().add(product);
		movementRepository.save(movement);
		
	}


	/*@Override
	public List<Product> getProductByMovementinUser(String userName) {
		
		List<Movement> movementsByUser = serviceUser.getMovmentsByUserName(userName);
		
		for (Movement m : movementsByUser) {
			m.getMovementProducts().add(null)
		}
		
		
		
		
		
		
		
	}*/

	

	

	

	

}
