package com.example.productsandcategories.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3,message = "name must be at least 3 characters")
    private String name;

    @Column(updatable = false)
    private Date created_at;
    private Date updated_at;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "categories_products" ,
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public @NotBlank @Size(min = 3, message = "name must be at least 3 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 3, message = "name must be at least 3 characters") String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated_at = new Date();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
