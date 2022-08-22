package com.codingdojo.productandcategory.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.services.ProductService;

@Controller
public class ProductsController {
	
	private final ProductService productService;
	
	public ProductsController(ProductService productService) {
		this.productService = productService;
		
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
