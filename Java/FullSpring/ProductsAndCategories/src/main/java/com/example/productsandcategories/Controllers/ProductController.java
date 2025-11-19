package com.example.productsandcategories.Controllers;

import com.example.productsandcategories.Models.Product;
import com.example.productsandcategories.Services.CategoryService;
import com.example.productsandcategories.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProductController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/products/new")
    public String showNewProduct(@ModelAttribute("product") Product product){
        return "newProduct";
    }

    @PostMapping("/products/new")
    public String newProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "newProduct";
        }
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable Long id, Model model){
        Product product = productService.getProductById(id);
        if(product != null) {
            model.addAttribute("product", product);
            model.addAttribute("excludedCategories", categoryService.categoriesNotON(product));
        }
        return "product";
    }

    @PostMapping("/products/{id}")
    public String addCategoryToProduct(@PathVariable Long id,@RequestParam("category_id") Long category_id) {
        Product product = productService.getProductById(id);
        if(product != null) {
            product.getCategories().add(categoryService.getCategoryById(category_id));
            productService.addProduct(product);

            return "redirect:/products/"+ id;
        }

        return "redirect:/";
    }

}
