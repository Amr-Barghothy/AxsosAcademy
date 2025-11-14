package com.example.renderingallbooks.Controllers;


import com.example.renderingallbooks.Models.Book;
import com.example.renderingallbooks.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/")
    public String index(Model model) {
        return "redirect:/books";
    }

    @RequestMapping("/books")
    public String books(Model model) {
        model.addAttribute("books",bookService.allBooks());
        return "index";
    }


    @RequestMapping("/book/{id}")
    public String book(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("books", book);
        return "details";
    }
}
