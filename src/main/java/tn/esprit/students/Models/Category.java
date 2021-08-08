package tn.esprit.students.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "T_Categories")
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idCategory ;
	@Indexed
	private String nameCategory ;
	
	private List<UnderCategory> underCategories;
	
	
	
	public List<UnderCategory> getUnderCategories() {
		return underCategories;
	}

	public void setUnderCategories(List<UnderCategory> underCategories) {
		this.underCategories = underCategories;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(String idCategory, String nameCategory) {
		super();
		this.idCategory = idCategory;
		this.nameCategory = nameCategory;
	}

	public Category(String nameCategory) {
		super();
		this.nameCategory = nameCategory;
	}

	public String getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCategory, nameCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		return Objects.equals(idCategory, other.idCategory) && Objects.equals(nameCategory, other.nameCategory);
	}

	@Override
	public String toString() {
		return "Category [idCategory=" + idCategory + ", nameCategory=" + nameCategory + "]";
	}
	
	
	
	

}
