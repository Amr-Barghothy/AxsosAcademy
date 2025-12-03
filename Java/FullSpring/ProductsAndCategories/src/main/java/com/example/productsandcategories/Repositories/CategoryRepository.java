package com.example.productsandcategories.Repositories;

import com.example.productsandcategories.Models.Category;
import com.example.productsandcategories.Models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findAll();

    List<Category> findByProductsNot(Product products);
    

}
