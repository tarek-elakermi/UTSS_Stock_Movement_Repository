package tn.esprit.students.Services;

import java.util.List;

import tn.esprit.students.Models.Category;

public interface CategoryService {
	
	List<Category> retrieveAllCategories();
	Category addCategory(Category c);
	Category updateCategory(Category c);
	Category retrieveCategory(String idCategory);
	void deleteCategory(String idCategory);
	
	

}
