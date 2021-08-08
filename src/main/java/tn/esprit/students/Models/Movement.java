package tn.esprit.students.Models;

import java.io.Serializable;


import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.NonNull;




@Document
public class Movement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idMovement ;
	
	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date dateCommand = new Date();
	
	
	@JsonProperty
	private TypeMov TypeMov ;
	
	private List<Product> MovementProducts;
	
	private User userMovement;
	
	
	
	public User getUserMovement() {
		return userMovement;
	}



	public void setUserMovement(User userMovement) {
		this.userMovement = userMovement;
	}



	public List<Product> getMovementProducts() {
		return MovementProducts;
	}



	public void setMovementProducts(List<Product> movementProducts) {
		MovementProducts = movementProducts;
	}



	public Movement() {
		super();
		// TODO Auto-generated constructor stub
	}
	


	public Movement(String idMovement, tn.esprit.students.Models.TypeMov typeMov) {
		super();
		this.idMovement = idMovement;
		TypeMov = typeMov;
	}



	public Movement(Date dateCommand, tn.esprit.students.Models.TypeMov typeMov) {
		super();
		this.dateCommand = dateCommand;
		TypeMov = typeMov;
	}
	
	


	public Movement(String idMovement, Date dateCommand, tn.esprit.students.Models.TypeMov typeMov) {
		super();
		this.idMovement = idMovement;
		this.dateCommand = dateCommand;
		TypeMov = typeMov;
	}



	public String getIdMovement() {
		return idMovement;
	}


	public void setIdMovement(String idMovement) {
		this.idMovement = idMovement;
	}


	public Date getDateCommand() {
		return dateCommand;
	}


	public void setDateCommand(Date dateCommand) {
		this.dateCommand = dateCommand;
	}

	
	public TypeMov getTypeMov() {
		return TypeMov;
	}


	public void setTypeMov(TypeMov typeMov) {
		TypeMov = typeMov;
	}


	@Override
	public int hashCode() {
		return Objects.hash(TypeMov, dateCommand, idMovement);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movement other = (Movement) obj;
		return TypeMov == other.TypeMov && Objects.equals(dateCommand, other.dateCommand)
				&& Objects.equals(idMovement, other.idMovement);
	}


	@Override
	public String toString() {
		return "Movement [idMovement=" + idMovement + ", dateCommand=" + dateCommand + ", TypeMov=" + TypeMov + "]";
	}


	
	
	
	
	
	
	
	

}
