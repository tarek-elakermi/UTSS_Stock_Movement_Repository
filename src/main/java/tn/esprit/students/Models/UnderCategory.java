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
@Document(collection = "T_UnderCategories")
public class UnderCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	private String idUnderCategory ;
	@Indexed
	private String nameUnderCategory ;
	
	private Category category;
	
	private List<Product> underProducts;
	
	
	

	public List<Product> getUnderProducts() {
		return underProducts;
	}

	public void setUnderProducts(List<Product> underProducts) {
		this.underProducts = underProducts;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public UnderCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnderCategory(String idUnderCategory, String nameUnderCategory) {
		super();
		this.idUnderCategory = idUnderCategory;
		this.nameUnderCategory = nameUnderCategory;
	}

	public UnderCategory(String nameUnderCategory) {
		super();
		this.nameUnderCategory = nameUnderCategory;
	}

	public String getIdUnderCategory() {
		return idUnderCategory;
	}

	public void setIdUnderCategory(String idUnderCategory) {
		this.idUnderCategory = idUnderCategory;
	}

	public String getNameUnderCategory() {
		return nameUnderCategory;
	}

	public void setNameUnderCategory(String nameUnderCategory) {
		this.nameUnderCategory = nameUnderCategory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUnderCategory, nameUnderCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnderCategory other = (UnderCategory) obj;
		return Objects.equals(idUnderCategory, other.idUnderCategory)
				&& Objects.equals(nameUnderCategory, other.nameUnderCategory);
	}

	@Override
	public String toString() {
		return "UnderCategory [idUnderCategory=" + idUnderCategory + ", nameUnderCategory=" + nameUnderCategory + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
