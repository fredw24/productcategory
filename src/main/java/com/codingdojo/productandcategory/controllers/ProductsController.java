package com.codingdojo.productandcategory.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.services.CategoryService;
import com.codingdojo.productandcategory.services.ProductService;

@Controller
public class ProductsController {
	
	private final ProductService productService;
	private final CategoryService categoryService;
	
	public ProductsController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
		
	}
	
	@RequestMapping("/product")
	public String index(Model model) {
		
		List<Product> products = productService.allProducts();
		model.addAttribute("products", products);
		return "/products/index.jsp";
		
	}
	
	@RequestMapping("/product/create")
	public String createProduct(@ModelAttribute("product") Product product) {
		
		return "/products/create.jsp";
	}
	
	
	@RequestMapping("/product/{id}")
	public String linkproduct(@PathVariable("id") Long id,  @ModelAttribute("category") Category category, Model model) {
		Product oneProduct = productService.findProduct(id);
		
		List<Category> notCategories = categoryService.findNotContainCategory(oneProduct);
		List<Category> categories = categoryService.findContainCategory(oneProduct);
		
		model.addAttribute("product", oneProduct);
		model.addAttribute("categories", categories);
		
		model.addAttribute("notCategories", notCategories);
		
		
		return "/products/linkproduct.jsp";
	}
	@RequestMapping(value="/product/link", method=RequestMethod.POST)
    public String productLink(@Valid @ModelAttribute("category") Product product, BindingResult result) {
		
		
        if (result.hasErrors()) {
            return "/product/create.jsp";
        } else {
         productService.linkCategory(product.getId(), product.getCategories().get(0).getId());
            return "redirect:/product";
        }
    }
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("product") Product product, BindingResult result) {
        if (result.hasErrors()) {
            return "/product/create.jsp";
        } else {
            productService.createProduct(product);
            return "redirect:/product";
        }
    }
	
}
