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

import tn.esprit.students.Models.User;
import tn.esprit.students.Services.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl serviceUser;
	
	@GetMapping("/AllUsers")
	public List<User> getAllUsers(){
		List<User> list = serviceUser.retrieveAllUser();
		return list;
	}
	
	@GetMapping("/OneUser/{idUser}")
	@ResponseBody
	public User getOneUser(@PathVariable("idUser") String idUser) {
		
			return serviceUser.retrieveUser(idUser);
		
	}
	
	@PostMapping(value = "/addUser")
	public User addUser(@RequestBody User user) {
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
