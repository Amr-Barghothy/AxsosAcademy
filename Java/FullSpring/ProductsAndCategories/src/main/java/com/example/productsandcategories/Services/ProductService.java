package com.example.productsandcategories.Services;

import com.example.productsandcategories.Models.Category;
import com.example.productsandcategories.Models.Product;
import com.example.productsandcategories.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }


    public List<Product> productsNotIn(Category category) {
        List<Product> cArr = category.getProducts();
        List<Product> pArr = getAllProducts();
        List<Product> Aux = new ArrayList<>();
        for (Product product : pArr) {
            if (!cArr.contains(product)) {
                Aux.add(product);
            }
        }
        return Aux;
    }



}
