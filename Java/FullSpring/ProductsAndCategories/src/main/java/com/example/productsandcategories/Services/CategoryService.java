package com.example.productsandcategories.Services;

import com.example.productsandcategories.Models.Category;
import com.example.productsandcategories.Models.Product;
import com.example.productsandcategories.Repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    public List<Category> categoriesNotON(Product product) {
        return categoryRepository.findByProductsNot(product);
    }
}
