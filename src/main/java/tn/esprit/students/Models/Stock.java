package tn.esprit.students.Models;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonProperty;


@Document
public class Stock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idStock ;
	@Indexed
	private String nameStock ;
	
	@JsonProperty
	private TypeStock TypeStock ;
	
	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date validityStock ;
	
	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date commingStock ;
	
	@CreatedDate
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private Date goingStock ;
	
	private int quantityStock ;
	private int costStock ;
	private int maxStock;
	private int minStock;
	
	private Store store;
	
	
	
	
	public Store getStore() {
		return store;
	}



	public void setStore(Store store) {
		this.store = store;
	}

	private List<Product> stockProducts;
	
	
	
	
	public List<Product> getStockProducts() {
		return stockProducts;
	}



	public void setStockProducts(List<Product> stockProducts) {
		this.stockProducts = stockProducts;
	}



	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Stock(String idStock, String nameStock, tn.esprit.students.Models.TypeStock typeStock, Date validityStock,
			Date commingStock, Date goingStock, int quantityStock, int costStock, int maxStock, int minStock) {
		super();
		this.idStock = idStock;
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.commingStock = commingStock;
		this.goingStock = goingStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
		this.maxStock = maxStock;
		this.minStock = minStock;
	}



	

	public Stock(String nameStock, tn.esprit.students.Models.TypeStock typeStock, Date validityStock, Date commingStock,
			Date goingStock, int quantityStock, int costStock, int maxStock, int minStock) {
		super();
		this.nameStock = nameStock;
		TypeStock = typeStock;
		this.validityStock = validityStock;
		this.commingStock = commingStock;
		this.goingStock = goingStock;
		this.quantityStock = quantityStock;
		this.costStock = costStock;
		this.maxStock = maxStock;
		this.minStock = minStock;
	}

	public Stock(String nameStock, Date validityStock, int quantityStock, int maxStock, int minStock) {
		super();
		this.nameStock = nameStock;
		this.validityStock = validityStock;
		this.quantityStock = quantityStock;
		this.maxStock = maxStock;
		this.minStock = minStock;
	}

	public String getIdStock() {
		return idStock;
	}

	public void setIdStock(String idStock) {
		this.idStock = idStock;
	}

	public String getNameStock() {
		return nameStock;
	}

	public void setNameStock(String nameStock) {
		this.nameStock = nameStock;
	}

	public TypeStock getTypeStock() {
		return TypeStock;
	}

	public void setTypeStock(TypeStock typeStock) {
		TypeStock = typeStock;
	}

	public Date getValidityStock() {
		return validityStock;
	}

	public void setValidityStock(Date validityStock) {
		this.validityStock = validityStock;
	}

	public Date getCommingStock() {
		return commingStock;
	}

	public void setCommingStock(Date commingStock) {
		this.commingStock = commingStock;
	}

	public Date getGoingStock() {
		return goingStock;
	}

	public void setGoingStock(Date goingStock) {
		this.goingStock = goingStock;
	}

	public int getQuantityStock() {
		return quantityStock;
	}

	public void setQuantityStock(int quantityStock) {
		this.quantityStock = quantityStock;
	}

	public int getCostStock() {
		return costStock;
	}

	public void setCostStock(int costStock) {
		this.costStock = costStock;
	}

	public int getMaxStock() {
		return maxStock;
	}

	public void setMaxStock(int maxStock) {
		this.maxStock = maxStock;
	}

	public int getMinStock() {
		return minStock;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}

	@Override
	public int hashCode() {
		return Objects.hash(TypeStock, commingStock, costStock, goingStock, idStock, maxStock, minStock, nameStock,
				quantityStock, validityStock);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return TypeStock == other.TypeStock && Objects.equals(commingStock, other.commingStock)
				&& costStock == other.costStock && Objects.equals(goingStock, other.goingStock)
				&& Objects.equals(idStock, other.idStock) && maxStock == other.maxStock && minStock == other.minStock
				&& Objects.equals(nameStock, other.nameStock) && quantityStock == other.quantityStock
				&& Objects.equals(validityStock, other.validityStock);
	}

	@Override
	public String toString() {
		return "Stock [idStock=" + idStock + ", nameStock=" + nameStock + ", TypeStock=" + TypeStock
				+ ", validityStock=" + validityStock + ", commingStock=" + commingStock + ", goingStock=" + goingStock
				+ ", quantityStock=" + quantityStock + ", costStock=" + costStock + ", maxStock=" + maxStock
				+ ", minStock=" + minStock + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
