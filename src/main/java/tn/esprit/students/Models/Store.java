package tn.esprit.students.Models;

import java.io.Serializable;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Store implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idStore ; 
	@Indexed
	private String nameStore ;
	@Indexed
	private String localisationStore ;
	
	
	private Stock stock;
	
	
	
	
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(String idStore, String nameStore, String localisationStore) {
		super();
		this.idStore = idStore;
		this.nameStore = nameStore;
		this.localisationStore = localisationStore;
	}

	public Store(String nameStore, String localisationStore) {
		super();
		this.nameStore = nameStore;
		this.localisationStore = localisationStore;
	}

	public String getIdStore() {
		return idStore;
	}

	public void setIdStore(String idStore) {
		this.idStore = idStore;
	}

	public String getNameStore() {
		return nameStore;
	}

	public void setNameStore(String nameStore) {
		this.nameStore = nameStore;
	}

	public String getLocalisationStore() {
		return localisationStore;
	}

	public void setLocalisationStore(String localisationStore) {
		this.localisationStore = localisationStore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idStore, localisationStore, nameStore);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Store other = (Store) obj;
		return Objects.equals(idStore, other.idStore) && Objects.equals(localisationStore, other.localisationStore)
				&& Objects.equals(nameStore, other.nameStore);
	}

	@Override
	public String toString() {
		return "Store [idStore=" + idStore + ", nameStore=" + nameStore + ", localisationStore=" + localisationStore
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
