package com.codingdojo.productandcategory.services;

import java.util.List;

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
    
//    public Product linkCategory(Product p) {
//    	
//    	// retrieve an instance of a category using another method in the service.
//        Category thisCategory = categoryRepository.findById(p.getId()).get();
//        
//        // retrieve an instance of a product using another method in the service.
//        Product thisProduct = productRepository.findById(p.getId()).get();
//        
//        // add the product to this category's list of products
//        thisCategory.getProducts().add(thisProduct);
//        
//        // Save thisCategory, since you made changes to its product list.
//        return productRepository.save(thisCategory);
//    }
	 
	 

}
