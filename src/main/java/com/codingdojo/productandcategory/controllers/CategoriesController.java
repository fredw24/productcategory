package com.codingdojo.productandcategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.models.Product;
import com.codingdojo.productandcategory.services.CategoryService;
import com.codingdojo.productandcategory.services.ProductService;


@Controller
public class CategoriesController {
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public CategoriesController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
		
	}
	
	@RequestMapping("/category")
	public String index(Model model) {
		
		List<Category> categorys = categoryService.allcategories();
		model.addAttribute("categories", categorys);
		return "/categories/index.jsp";
		
	}
	
	@RequestMapping("/category/create")
	public String createcategory(@ModelAttribute("category") Category category) {
		
		return "/categories/create.jsp";
	}
	
	@RequestMapping(value="/category", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "/category/create.jsp";
        } else {
            categoryService.createCategory(category);
            return "redirect:/category";
        }
    }
	
	@RequestMapping("/category/{id}")
	public String linkcategory(@PathVariable("id") Long id,  @ModelAttribute("category") Category category, Model model) {
		Category oneCategory = categoryService.findCategory(id);
		
		List<Product> notProducts = productService.findNotContainProducts(oneCategory);
		List<Product> products = productService.findContainProducts(oneCategory);
		
		model.addAttribute("category", oneCategory);
		model.addAttribute("products", products);
		
		model.addAttribute("notProducts", notProducts);
		
		
		return "/categories/linkcategory.jsp";
	}
	
	@RequestMapping(value="/category/link", method=RequestMethod.POST)
    public String categoryLink(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		
		
        if (result.hasErrors()) {
            return "/category/create.jsp";
        } else {
         categoryService.linkProduct(category.getId(), category.getProducts().get(0).getId());
            return "redirect:/category";
        }
    }
}
