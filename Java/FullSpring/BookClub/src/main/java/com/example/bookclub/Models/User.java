package com.example.bookclub.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name is required")
    @Size(min = 3 , message = "The name should be at least 3 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "The Email is invalid")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8 , message = "The password should be at least 8 characters")
    private String password;

    @NotBlank(message = "Confirm Password is required")
    @Transient
    private String confirmPassword;

    @Column(updatable = false)
    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Book> books;

    @OneToMany(mappedBy = "commentedUser",fetch = FetchType.LAZY)
    private List<Book> comments;

    public User() {
    }

    public User(String name, String email, String password, String confirmPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public @NotBlank @Size(min = 3) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 3) String name) {
        this.name = name;
    }

    public @NotBlank @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email String email) {
        this.email = email;
    }

    public @NotBlank @Size(min = 8) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Size(min = 8) String password) {
        this.password = password;
    }

    public @NotBlank String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(@NotBlank String confirmPassword) {
        this.confirmPassword = confirmPassword;
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
