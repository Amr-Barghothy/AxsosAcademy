package com.example.renderingallbooks.Controllers;


import com.example.renderingallbooks.Models.Book;
import com.example.renderingallbooks.Services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/create")
    public String create(){
        Book book2 = new Book("dsddsads","sadsdasd","sadadsdsadas",123);
        bookService.createBook(book2);
        return "Book created";
    }

    @PutMapping("/api/books/{id}")
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        System.out.println(title + " " + desc);
        return bookService.updateBook(id, title, desc, lang, numOfPages);
    }

    @DeleteMapping("/delete/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}