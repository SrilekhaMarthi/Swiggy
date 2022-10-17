package com.swiggy.app.Controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.app.GResponse.GResponse;
import com.swiggy.app.Service.CategoryService;
import com.swiggy.app.model.Category;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	private CategoryService CategoryService;
	private GResponse gResponse;
	
	public CategoryController(CategoryService CategoryService,GResponse gResponse) {
		this.CategoryService=CategoryService;
		this.gResponse=gResponse;
	}
	
	@GetMapping("/all")
	public GResponse getAllCategories() {
		gResponse.setData(CategoryService.getAllCategories());
		gResponse.setStatus(gResponse.getStatus());
		return gResponse;
	}
	
	@GetMapping("/{id}")
	public GResponse getCategoryById(@PathVariable Long id) {
		gResponse.setData(CategoryService.getCategoryById(id));
		gResponse.setStatus(HttpStatus.OK.value());
		//System.out.println("Controller:"+gResponse);
		return gResponse;
	}
	
	@PostMapping
	public GResponse addCategory(@Valid @RequestBody Category Category) {
		gResponse.setData(CategoryService.addCategory(Category));
		return gResponse;
	}
	
	
//	logger4j  
	
	@PutMapping("/{id}")
	public GResponse updateCategory(@Valid @RequestBody Category Category,@PathVariable Long id) {
		gResponse.setData(CategoryService.updateCategory(Category, id));
		return gResponse;
	}
	
	@DeleteMapping("/{id}")
	public GResponse deleteCategory(@PathVariable Long id) {
		gResponse.setData(CategoryService.deleteCategory(id));
		return gResponse;
	}
	
}
