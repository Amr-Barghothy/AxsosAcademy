package com.example.renderingbooks.Controllers;


import com.example.renderingbooks.Models.Book;
import com.example.renderingbooks.Services.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    // other methods removed for brevity
    @RequestMapping("/api/books/{id}")
    public Book update(
            @PathVariable("id") Long id,
            @RequestParam(value="title") String title,
            @RequestParam(value="description") String desc,
            @RequestParam(value="language") String lang,
            @RequestParam(value="pages") Integer numOfPages) {
        System.out.println(title + " " + desc);
        return bookService.updateBook(id, title, desc, lang, numOfPages);
    }

    @RequestMapping("/delete/books/{id}")
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
}