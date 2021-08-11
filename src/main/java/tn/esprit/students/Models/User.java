package tn.esprit.students.Models;

import java.io.Serializable;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Document

@AllArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Transient
	public static final String SEQUENCE_NAME="user_sequence";
	
	
	@Id
	protected String idUser ;
	@Indexed
	protected String lastnameUser ;
	@Indexed
	protected String firstnameUser ;
	protected  long CinUser ;
	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	protected Date birthDateUser ;
	protected String passwordUser ;
	protected String confirmpasswordUser ;
	protected String phoneNumberUser ;
	protected boolean stateUser ;
	protected String emailUser ;
	
	@JsonProperty
	private Role role;
	
	
	private List<Movement> userMovement;
	
	
	
	public List<Movement> getUserMovement() {
		return userMovement;
	}



	public void setUserMovement(List<Movement> userMovement) {
		this.userMovement = userMovement;
	}



	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public User(String idUser, String lastnameUser, String firstnameUser) {
		super();
		this.idUser = idUser;
		this.lastnameUser = lastnameUser;
		this.firstnameUser = firstnameUser;
	}



	public User(String idUser, String lastnameUser, String firstnameUser, long cinUser, Date birthDateUser,
			String passwordUser, String confirmpasswordUser, String phoneNumberUser, boolean stateUser,
			String emailUser, Role role) {
		super();
		this.idUser = idUser;
		this.lastnameUser = lastnameUser;
		this.firstnameUser = firstnameUser;
		CinUser = cinUser;
		this.birthDateUser = birthDateUser;
		this.passwordUser = passwordUser;
		this.confirmpasswordUser = confirmpasswordUser;
		this.phoneNumberUser = phoneNumberUser;
		this.stateUser = stateUser;
		this.emailUser = emailUser;
		this.role = role;
	}

	public User(String lastnameUser, String firstnameUser, long cinUser, Date birthDateUser, String passwordUser,
			String confirmpasswordUser, String phoneNumberUser, boolean stateUser, String emailUser, Role role) {
		super();
		this.lastnameUser = lastnameUser;
		this.firstnameUser = firstnameUser;
		CinUser = cinUser;
		this.birthDateUser = birthDateUser;
		this.passwordUser = passwordUser;
		this.confirmpasswordUser = confirmpasswordUser;
		this.phoneNumberUser = phoneNumberUser;
		this.stateUser = stateUser;
		this.emailUser = emailUser;
		this.role = role;
	}
	
	

	public User(String lastnameUser, String firstnameUser, long cinUser) {
		super();
		this.lastnameUser = lastnameUser;
		this.firstnameUser = firstnameUser;
		CinUser = cinUser;
	}

	public String getIdUser() {
		return idUser;
	}

	public void setIdUser(String i) {
		this.idUser = i;
	}

	public String getLastnameUser() {
		return lastnameUser;
	}

	public void setLastnameUser(String lastnameUser) {
		this.lastnameUser = lastnameUser;
	}

	public String getFirstnameUser() {
		return firstnameUser;
	}

	public void setFirstnameUser(String firstnameUser) {
		this.firstnameUser = firstnameUser;
	}

	public long getCinUser() {
		return CinUser;
	}

	public void setCinUser(long cinUser) {
		CinUser = cinUser;
	}

	public Date getBirthDateUser() {
		return birthDateUser;
	}

	public void setBirthDateUser(Date birthDateUser) {
		this.birthDateUser = birthDateUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public String getConfirmpasswordUser() {
		return confirmpasswordUser;
	}

	public void setConfirmpasswordUser(String confirmpasswordUser) {
		this.confirmpasswordUser = confirmpasswordUser;
	}

	public String getPhoneNumberUser() {
		return phoneNumberUser;
	}

	public void setPhoneNumberUser(String phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}

	public boolean isStateUser() {
		return stateUser;
	}

	public void setStateUser(boolean stateUser) {
		this.stateUser = stateUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(CinUser, birthDateUser, confirmpasswordUser, emailUser, firstnameUser, idUser, lastnameUser,
				passwordUser, phoneNumberUser, role, stateUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return CinUser == other.CinUser && Objects.equals(birthDateUser, other.birthDateUser)
				&& Objects.equals(confirmpasswordUser, other.confirmpasswordUser)
				&& Objects.equals(emailUser, other.emailUser) && Objects.equals(firstnameUser, other.firstnameUser)
				&& Objects.equals(idUser, other.idUser) && Objects.equals(lastnameUser, other.lastnameUser)
				&& Objects.equals(passwordUser, other.passwordUser)
				&& Objects.equals(phoneNumberUser, other.phoneNumberUser) && role == other.role
				&& stateUser == other.stateUser;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", lastnameUser=" + lastnameUser + ", firstnameUser=" + firstnameUser
				+ ", CinUser=" + CinUser + ", birthDateUser=" + birthDateUser + ", passwordUser=" + passwordUser
				+ ", confirmpasswordUser=" + confirmpasswordUser + ", phoneNumberUser=" + phoneNumberUser
				+ ", stateUser=" + stateUser + ", emailUser=" + emailUser + ", role=" + role + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
