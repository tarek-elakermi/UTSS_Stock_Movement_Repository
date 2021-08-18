package tn.esprit.students.Services;


import java.util.List;


import tn.esprit.students.Models.UnderCategory;

public interface UnderCategoryService{
	
	List<UnderCategory> retrieveAllUnderCategories();
	UnderCategory addUnderCategory(UnderCategory c);
	UnderCategory updateUnderCategory(UnderCategory c);
	UnderCategory retrieveUnderCategory(String idUnderCategory);
	void deleteUnderCategory(String idUnderCategory);
	
	void affectProductToUnderCtegoryt(String idUnderCategory, String idProduct) throws Exception;
	
	UnderCategory getUnderCategoryByName(String nameUnderCategory);
	
	public int countProduct(String nameUnderCategory);
	
	
	 

}
