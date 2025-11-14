package com.example.booksapi.Controllers;

import com.example.booksapi.Models.Book;
import com.example.booksapi.Services.BookService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BooksApi {
    private final BookService bookService;
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }

    @RequestMapping("/")
    public String index(){
        return "Hello World";
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