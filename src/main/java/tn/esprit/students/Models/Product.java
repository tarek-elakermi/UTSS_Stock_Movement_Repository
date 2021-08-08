package tn.esprit.students.Models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "T_Products")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String idProduct ;
	private String titleProduct ;
	private String descriptionProduct ;
	private int quantityProduct ;
	@Indexed(direction = IndexDirection.ASCENDING)
	private float priceProduct ;
	private float weightProduct ;
	@Indexed(direction = IndexDirection.ASCENDING)
	private float buyingPriceProduct ;
	private int maxQuantityProduct ;
	private String imageProd ;
	
	private UnderCategory underCategory;
	
	private Stock stock;
	
	private List<Movement> productMovement;
	
	


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}


	public List<Movement> getProductMovement() {
		return productMovement;
	}


	public void setProductMovement(List<Movement> productMovement) {
		this.productMovement = productMovement;
	}


	public UnderCategory getUnderCategory() {
		return underCategory;
	}


	public void setUnderCategory(UnderCategory underCategory) {
		this.underCategory = underCategory;
	}


	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(String idProduct, String titleProduct, String descriptionProduct, int quantityProduct,
			float priceProduct, float weightProduct, float buyingPriceProduct, int maxQuantityProduct,
			String imageProd) {
		super();
		this.idProduct = idProduct;
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.imageProd = imageProd;
	}


	public Product(String titleProduct, String descriptionProduct, int quantityProduct, float priceProduct,
			float weightProduct, float buyingPriceProduct, int maxQuantityProduct, String imageProd) {
		super();
		this.titleProduct = titleProduct;
		this.descriptionProduct = descriptionProduct;
		this.quantityProduct = quantityProduct;
		this.priceProduct = priceProduct;
		this.weightProduct = weightProduct;
		this.buyingPriceProduct = buyingPriceProduct;
		this.maxQuantityProduct = maxQuantityProduct;
		this.imageProd = imageProd;
	}


	public String getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}


	public String getTitleProduct() {
		return titleProduct;
	}


	public void setTitleProduct(String titleProduct) {
		this.titleProduct = titleProduct;
	}


	public String getDescriptionProduct() {
		return descriptionProduct;
	}


	public void setDescriptionProduct(String descriptionProduct) {
		this.descriptionProduct = descriptionProduct;
	}


	public int getQuantityProduct() {
		return quantityProduct;
	}


	public void setQuantityProduct(int quantityProduct) {
		this.quantityProduct = quantityProduct;
	}


	public float getPriceProduct() {
		return priceProduct;
	}


	public void setPriceProduct(float priceProduct) {
		this.priceProduct = priceProduct;
	}


	public float getWeightProduct() {
		return weightProduct;
	}


	public void setWeightProduct(float weightProduct) {
		this.weightProduct = weightProduct;
	}


	public float getBuyingPriceProduct() {
		return buyingPriceProduct;
	}


	public void setBuyingPriceProduct(float buyingPriceProduct) {
		this.buyingPriceProduct = buyingPriceProduct;
	}


	public int getMaxQuantityProduct() {
		return maxQuantityProduct;
	}


	public void setMaxQuantityProduct(int maxQuantityProduct) {
		this.maxQuantityProduct = maxQuantityProduct;
	}


	public String getImageProd() {
		return imageProd;
	}


	public void setImageProd(String imageProd) {
		this.imageProd = imageProd;
	}


	@Override
	public int hashCode() {
		return Objects.hash(buyingPriceProduct, descriptionProduct, idProduct, imageProd, maxQuantityProduct,
				priceProduct, quantityProduct, titleProduct, weightProduct);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Float.floatToIntBits(buyingPriceProduct) == Float.floatToIntBits(other.buyingPriceProduct)
				&& Objects.equals(descriptionProduct, other.descriptionProduct)
				&& Objects.equals(idProduct, other.idProduct) && Objects.equals(imageProd, other.imageProd)
				&& maxQuantityProduct == other.maxQuantityProduct
				&& Float.floatToIntBits(priceProduct) == Float.floatToIntBits(other.priceProduct)
				&& quantityProduct == other.quantityProduct && Objects.equals(titleProduct, other.titleProduct)
				&& Float.floatToIntBits(weightProduct) == Float.floatToIntBits(other.weightProduct);
	}


	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", titleProduct=" + titleProduct + ", descriptionProduct="
				+ descriptionProduct + ", quantityProduct=" + quantityProduct + ", priceProduct=" + priceProduct
				+ ", weightProduct=" + weightProduct + ", buyingPriceProduct=" + buyingPriceProduct
				+ ", maxQuantityProduct=" + maxQuantityProduct + ", imageProd=" + imageProd + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
