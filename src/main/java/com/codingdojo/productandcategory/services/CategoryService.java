package com.codingdojo.productandcategory.services;

import java.util.List;
import java.util.Optional;

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
	 
	 public Category findCategory(Long id) {
		 Optional<Category> oneCategory = categoryRepository.findById(id);
		 if (oneCategory.get()!= null) {
			 return oneCategory.get();
		 }
		 else {
			 return null;
		 }
		 
	 }
	 
	 
	 public List<Category> findNotContainProducts(Product product){
		 
		 List<Category> findNot = categoryRepository.findByProductsNotContains(product);
		 return findNot;
		 
	 }
	 
	 public List<Category> findContainProducts(Product product){
		 
		 List<Category> findProducts = categoryRepository.findAllByProducts(product);
		 return findProducts;
		 
	 }
	 
	 public List<Category> allcategories(){
		 List<Category> allList = categoryRepository.findAll();
		 return allList;
	 }
	 
	 
	// creates a Category
	   public Category createCategory(Category c) {
	   	return categoryRepository.save(c);
	   }
	   
	   public List<Category> findNotContainCategory(Product product){
		   List<Category> findNot = categoryRepository.findByProductsNotContains(product);
		   return findNot;
		   
	   }
	   
	   public List<Category> findContainCategory(Product product){
		   List<Category> findOne = categoryRepository.findAllByProducts(product);
		   return findOne;
	   }
	   
	 public void linkProduct(Long categoryId, Long productId) {
		// retrieve an instance of a category using another method in the service.
		    Optional<Category> thisCategory = categoryRepository.findById(categoryId);
		    
		    // retrieve an instance of a product using another method in the service.
		    Optional<Product> thisProduct = productRepository.findById(productId);
		    
		    // add the product to this category's list of products
		    thisCategory.get().getProducts().add(thisProduct.get());
		    
		    // Save thisCategory, since you made changes to its product list.
		    categoryRepository.save(thisCategory.get());
		 
	 }

}
