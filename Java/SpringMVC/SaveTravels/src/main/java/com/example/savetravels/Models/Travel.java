package com.example.savetravels.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "travel")
public class Travel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5)
    private String expenseName;
    @NotNull
    @Size(min= 5)
    private String vendor;
    @NotNull
    private double amount;
    @NotNull
    @Size(min = 10, message = "description must be at least 10 characters")
    private String description;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
    public Travel() {
    }

    public Travel(String expenseName, String vendor, double amount, String description) {
        this.expenseName = expenseName;
        this.vendor = vendor;
        this.amount = amount;
        this.description = description;
    }

    public @NotNull String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(@NotNull String expenseName) {
        this.expenseName = expenseName;
    }

    public @NotNull String getVendor() {
        return vendor;
    }

    public void setVendor(@NotNull String vendor) {
        this.vendor = vendor;
    }

    @NotNull
    public double getAmount() {
        return amount;
    }

    public void setAmount(@NotNull double amount) {
        this.amount = amount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Size(min = 10, message = "description must be at least 10 characters") String description) {
        this.description = description;
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
