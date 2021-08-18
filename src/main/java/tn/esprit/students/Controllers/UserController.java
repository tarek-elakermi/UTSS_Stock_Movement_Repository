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
import tn.esprit.students.Models.MovementRepository;
import tn.esprit.students.Models.SequenceGeneretorService;
import tn.esprit.students.Models.User;
import tn.esprit.students.Services.MovementServiceImpl;
import tn.esprit.students.Services.UserServiceImpl;


@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl serviceUser;
	
	@Autowired
	private MovementRepository movementRepository;
	
	@Autowired
	private MovementServiceImpl serviceMovement;
	
	@Autowired
	private SequenceGeneretorService service;
	
	@GetMapping("/AllUsers")
	public List<User> getAllUsers(){
		List<User> list = serviceUser.retrieveAllUser();
		return list;
	}
	
	@GetMapping("/OneUser/{idUser}")
	@ResponseBody
	public String getOneUser(@PathVariable("idUser") String idUser) {
		
			User user = serviceUser.retrieveUser(idUser);
			 
			 return "user name is :"+" " + user.getUserName() +"\n"+ "his phone number is :" +" "+ user.getPhoneNumberUser() 
			 +"\n"+"he did "+ user.getUserMovement().size() + " " + "movements :" + "\n" + " " + user.getUserMovement().toString()
			 +"\n"+"contient les produits suivants : " ;
		
	}
	
	@PostMapping(value = "/addUser")
	public User addUser(@RequestBody User user) {
		user.setIdUser(String.valueOf(service.getSequenceNumber(User.SEQUENCE_NAME)));
		serviceUser.addUser(user);
		return user;
		
	}
	
	@PutMapping(value = "/updateUser")
	public User updateUser(@RequestBody User user) {
		return serviceUser.updateUser(user);
		
	}
	
	@DeleteMapping(value = "/deleteUser/{idUser}")
	public void deleteMovement(@PathVariable("idUser") String idUser) {
		serviceUser.deleteUser(idUser);
	}
	
	@PutMapping(value = "/affectUserToMovement/{idUser}/{idMovement}")
	public void affectUserToMovement(@PathVariable("idUser") String idUser , @PathVariable("idMovement") String idMovement) {
		serviceUser.affecterUserToMovement(idUser, idMovement);
	}
	
	@GetMapping(value = "/getMovementByUserName/{userName}")
	public List<Movement> getMovementByUserName(@PathVariable("userName")String userName){
		return serviceUser.getMovmentsByUserName(userName);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
