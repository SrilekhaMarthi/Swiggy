package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.CategoryRepository;
import com.swiggy.app.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository categoryRepo;
	
	public CategoryServiceImpl(CategoryRepository categoryRepo) {
		this.categoryRepo=categoryRepo;
	}
	
	@Override
	public List<Category> getAllCategories(){
		return categoryRepo.findAll();
	}
	
	@Override
	public Category getCategoryById(Long id) {
		return categoryRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		
	}
	
	@Override
	public Category addCategory(Category category) {
		return categoryRepo.save(category);
	}
	
	@Override
	public Category updateCategory(Category category,Long id) {
		Boolean exists = categoryRepo.existsById(id);
		if (exists) {
			return categoryRepo.save(category);
		} 
		return null;
	}
	
	@Override
	public Category deleteCategory(Long id) {
		categoryRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		Category rest = categoryRepo.findById(id).get();
		categoryRepo.deleteById(id);
		 return rest;
	}
}
