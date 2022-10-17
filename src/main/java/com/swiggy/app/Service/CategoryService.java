package com.swiggy.app.Service;

import java.util.List;

import com.swiggy.app.model.Category;

public interface CategoryService {

	List<Category> getAllCategories();

	Category getCategoryById(Long id);

	Category addCategory(Category category);

	Category updateCategory(Category category, Long id);

	Category deleteCategory(Long id);

}
