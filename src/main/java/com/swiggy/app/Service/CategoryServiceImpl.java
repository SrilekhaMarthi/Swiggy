package com.swiggy.app.Service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.swiggy.app.Repository.CategoryRepository;
import com.swiggy.app.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	private CategoryRepository CategoryRepo;
	
	public CategoryServiceImpl(CategoryRepository CategoryRepo) {
		this.CategoryRepo=CategoryRepo;
	}
	
	@Override
	public List<Category> getAllCategories(){
		return CategoryRepo.findAll();
	}
	
	@Override
	public Category getCategoryById(Long id) {
		return CategoryRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		
	}
	
	@Override
	public Category addCategory(Category Category) {
		return CategoryRepo.save(Category);
	}
	
	@Override
	public Category updateCategory(Category category,Long id) {
		Boolean exists = CategoryRepo.existsById(id);
		if (exists) {
			return CategoryRepo.save(category);
		} 
		return null;
	}
	
	@Override
	public Category deleteCategory(Long id) {
		CategoryRepo.findById(id).orElseThrow(()->new NoSuchElementException());
		Category rest = CategoryRepo.findById(id).get();
		 CategoryRepo.deleteById(id);
		 return rest;
	}
}
