package com.example.productsandcategories.Controllers;

import com.example.productsandcategories.Models.Category;
import com.example.productsandcategories.Services.CategoryService;
import com.example.productsandcategories.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;

    @GetMapping("/category/new")
    public String showNewCategory(@ModelAttribute("category") Category category) {
        return "newCategory";
    }

    @PostMapping("/category/new")
    public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newCategory";
        }
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("/category/{id}")
    public String productDetails(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            model.addAttribute("category", category);
            model.addAttribute("excludedProducts", productService.productsNotIn(category));
        }
        return "category";
    }

    @PostMapping("/category/{id}")
    public String addCategoryToProduct(@PathVariable Long id, @RequestParam("product_id") Long product_id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            category.getProducts().add(productService.getProductById(product_id));
            categoryService.addCategory(category);

            return "redirect:/category/" + id;
        }

        return "redirect:/";
    }

}
