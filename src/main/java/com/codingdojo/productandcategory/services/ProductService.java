package com.codingdojo.productandcategory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.repositories.CategoryRepository;
import com.codingdojo.productandcategory.repositories.ProductRepository;

@Service
public class ProductService {
	
	 private final ProductRepository productRepository;
	 
	 private final CategoryRepository categoryRepository;
	 
	 
	 
	 public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		 this.productRepository = productRepository;
		 this.categoryRepository = categoryRepository;
		 
	 }
	 
	 public List<Product> allProducts() {
	       
		 return productRepository.findAll();
	 }
	 
	// creates a Product
    public Product createProduct(Product p) {
    	return productRepository.save(p);
    }
    
    public List<Product> findNotContainProducts(Category category){
		 
		 List<Product> findNot = productRepository.findByCategoriesNotContains(category);
		 return findNot;
		 
	 }
	 
	 public List<Product> findContainProducts(Category category){
		 
		 List<Product> findCategories = productRepository.findAllByCategories(category);
		 return findCategories;
		 
	 }
	 
	 public Product findProduct(Long id) {
		 
		 Product one = productRepository.findById(id).get();
		 return one;
	 }
    
    
    public void linkCategory(Long productId, Long categoryId) {
		// retrieve an instance of a category using another method in the service.
		    Optional<Category> thisCategory = categoryRepository.findById(categoryId);
		    
		    // retrieve an instance of a product using another method in the service.
		    Optional<Product> thisProduct = productRepository.findById(productId);
		    
		 // This has the same affect as above:
		    thisProduct.get().getCategories().add(thisCategory.get());	
		    // add the category to this products's list of categories
		    productRepository.save(thisProduct.get());	
		    // Save thisProduct, since you made changes to its category list.
		 
	 }
	 
	 

}
