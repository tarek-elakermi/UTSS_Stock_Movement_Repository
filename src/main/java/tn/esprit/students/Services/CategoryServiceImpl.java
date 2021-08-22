package tn.esprit.students.Services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.students.Models.Category;
import tn.esprit.students.Models.CategoryRepository;
import tn.esprit.students.Models.UnderCategory;
import tn.esprit.students.Models.UnderCategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private UnderCategoryRepository ucr ;
	
	
	private static final Logger L = LogManager.getLogger(CategoryServiceImpl.class);

	@Override
	public List<Category> retrieveAllCategories() {
		List<Category> categories = (List<Category>) categoryRepository.findAll();
		for (Category category : categories) {
			L.info("categories +++ :" + category );
		}
		return categories;
	}

	@Override
	public Category addCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public Category updateCategory(Category c) {
		return categoryRepository.save(c);
	}

	@Override
	public Category retrieveCategory(String idCategory) {
		Category category = categoryRepository.findById(idCategory).get();
		L.info("category returned +++ :" + category);
		return category;
	}

	@Override
	public void deleteCategory(String idCategory) {
		categoryRepository.deleteById(idCategory);
		
	}

	@Override
	public void affectUnderCategoryToCategory(String idCategory, String idUnderCategory) {
		Category category=categoryRepository.findById(idCategory).get();
		UnderCategory undercategory=ucr.findById(idUnderCategory).get();
		
		undercategory.setCategory(category);
		ucr.save(undercategory);
	}
	
	
	
	
	
}
