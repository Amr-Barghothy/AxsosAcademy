package com.example.productsandcategories.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(min = 3,message = "name must be at least 3 characters")
    private String name;

    @NotBlank
    @Size(min = 3,message = "description must be at least 3 characters")
    private String description;

    @NotNull
    private double price;

    @Column(updatable = false)
    private Date created_at;
    private Date updated_at;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "categories_products" ,
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    public Product() {
    }

    public Product(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public @NotBlank @Size(min = 3, message = "name must be at least 3 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 3, message = "name must be at least 3 characters") String name) {
        this.name = name;
    }

    public @NotBlank @Size(min = 3, message = "description must be at least 3 characters") String getDescription() {
        return description;
    }

    public void setDescription(@NotBlank @Size(min = 3, message = "description must be at least 3 characters") String description) {
        this.description = description;
    }

    @NotNull
    public double getPrice() {
        return price;
    }

    public void setPrice(@NotNull double price) {
        this.price = price;
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

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
