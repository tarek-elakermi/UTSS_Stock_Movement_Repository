package tn.esprit.students.Services;

import java.util.List;

import tn.esprit.students.Models.Movement;
import tn.esprit.students.Models.User;

public interface UserService {
	
	List<User> retrieveAllUser();
	User addUser(User u);
	User updateUser(User u);
	User retrieveUser(String idUser);
	void deleteUser(String idUser);
	
	void affecterUserToMovement(String idUser , String idMovement);
	
	List<Movement> getMovmentsByUserName(String userName);

}
