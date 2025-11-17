package com.example.loginandregistration.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is required")
    @Size(min = 3 , message = "The username should be at least 3 characters")
    @Column(unique = true)
    private String username;

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

    public User() {
    }

    public User(String username, String email, String password, String confirmPassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public @NotBlank @Size(min = 3) String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank @Size(min = 3) String username) {
        this.username = username;
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
