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
		Category category1  = categoryRepo.findById(id).get();
		if (category1 != null) {
			if (category.getName()!= null) {
				category1.setName(category.getName());
			}
			return category1;
		} else {
			categoryRepo.save(category);
			return category;
		}
	}
	
	@Override
	public String deleteCategory(Long id) {
		if(id!=null) {
			categoryRepo.deleteById(id);
			return "deleted successfully!";
		}
		else {
			throw new NoSuchElementException();
		}
	}
}
