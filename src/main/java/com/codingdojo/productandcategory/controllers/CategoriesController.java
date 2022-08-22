package com.codingdojo.productandcategory.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.productandcategory.models.Category;
import com.codingdojo.productandcategory.services.CategoryService;


@Controller
public class CategoriesController {
	private final CategoryService categoryService;
	
	public CategoriesController(CategoryService categoryService) {
		this.categoryService = categoryService;
		
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
}
