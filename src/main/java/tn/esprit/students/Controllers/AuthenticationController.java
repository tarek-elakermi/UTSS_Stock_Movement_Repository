package tn.esprit.students.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.students.Models.AuthenticationRequest;
import tn.esprit.students.Models.AuthenticationResponse;
import tn.esprit.students.Models.User;
import tn.esprit.students.Models.UserRepository;

@RestController
public class AuthenticationController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping(value = "/subscribe")
	private ResponseEntity<?> subscribeClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUserName();
		String password = authenticationRequest.getPasswordUser();
		User user = new User();
		user.setUserName(username);
		user.setPasswordUser(password);
		
		
		
		try {
			userRepository.save(user);
			
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error During Subscription for client" + username));
		}
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Succesful Subscription for client" + username));
		
	}
	
	
	@PostMapping(value = "/authenticate")
	private ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
		
		String username = authenticationRequest.getUserName();
		String password = authenticationRequest.getPasswordUser();
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			
		} catch (Exception e) {
			return ResponseEntity.ok(new AuthenticationResponse("Error During Authentication for client" + username));
// TODO: handle exception
		}
		
		
		return ResponseEntity.ok(new AuthenticationResponse("Succesful Authentication for client" + username ));

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
