package com.codingdojo.productandcategory.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.repositories.CategoryRepository;
import com.codingdojo.productandcategory.repositories.ProductRepository;

@Service
public class CategoryService {
	
//	private final CategoryService categoryService;
//	
//	public CategoryService(CategoryService categoryService) {
//		this.categoryService = categoryService;
//	}
	
	 private final ProductRepository productRepository;
	 
	 private final CategoryRepository categoryRepository;
	 
	 
	 
	 public CategoryService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		 this.productRepository = productRepository;
		 this.categoryRepository = categoryRepository;
		 
	 }
	 
	 public List<Category> allcategories(){
		 List<Category> allList = categoryRepository.findAll();
		 return allList;
	 }
	 
	 
	// creates a Product
	   public Category createCategory(Category c) {
	   	return categoryRepository.save(c);
	   }

}
