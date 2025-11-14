package com.example.renderingbooks.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Entity
@Table(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200)
    private String description;
    @NotNull
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    public Book() {
    }
    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull @Size(min = 5, max = 200) String getTitle() {
        return title;
    }

    public void setTitle(@NotNull @Size(min = 5, max = 200) String title) {
        this.title = title;
    }

    public @NotNull @Size(min = 5, max = 200) String getDescription() {
        return description;
    }

    public void setDescription(@NotNull @Size(min = 5, max = 200) String description) {
        this.description = description;
    }

    public @NotNull @Size(min = 3, max = 40) String getLanguage() {
        return language;
    }

    public void setLanguage(@NotNull @Size(min = 3, max = 40) String language) {
        this.language = language;
    }

    public @NotNull @Min(100) Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(@NotNull @Min(100) Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}