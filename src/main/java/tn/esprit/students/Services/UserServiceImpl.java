package tn.esprit.students.Services;

import java.util.ArrayList;
import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tn.esprit.students.Models.User;
import tn.esprit.students.Models.UserRepository;

@Service
public class UserServiceImpl implements UserService , UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	@Override
	public List<User> retrieveAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
		for (User user : users) {
			L.info("users +++ :" + user );
		}
		return users;
	}

	@Override
	public User addUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User retrieveUser(String idUser) {
		User user = userRepository.findById(idUser).get();
		L.info("user returned +++ :" + user);
		return user;
	}

	@Override
	public void deleteUser(String idUser) {
		 userRepository.deleteById(idUser);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User foundedUser = userRepository.findByUserName(username);
		if (foundedUser == null) return null ;
		
		
		String name = foundedUser.getFirstnameUser();
		String pwd = foundedUser.getPasswordUser();
		
		return new org.springframework.security.core.userdetails.User(username, pwd, new ArrayList<>());
		
	}

	

		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
