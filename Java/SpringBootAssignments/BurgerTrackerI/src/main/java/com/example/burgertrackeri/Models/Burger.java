package com.example.burgertrackeri.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "burger")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5)
    private String burgerName;
    @NotNull
    @Size(min= 5)
    private String restaurantName;
    @NotNull
    private int rating;
    @NotNull
    @Size(min = 10, message = "note must be at least 10 characters")
    private String note;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    public Burger() {
    }

    public Burger(String burgerName, String restaurantName, int rating, String note) {
        this.burgerName = burgerName;
        this.restaurantName = restaurantName;
        this.rating = rating;
        this.note = note;
    }

    public @NotNull String getBurgerName() {
        return burgerName;
    }

    public void setBurgerName(@NotNull String burgerName) {
        this.burgerName = burgerName;
    }

    public @NotNull String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(@NotNull String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @NotNull
    public int getRating() {
        return rating;
    }

    public void setRating(@NotNull int rating) {
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getNote() {
        return note;
    }

    public void setNote(@NotNull @Size(min = 10, message = "note must be at least 10 characters") String note) {
        this.note = note;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
