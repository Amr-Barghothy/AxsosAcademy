package com.example.renderingbooks.Controllers;

import com.example.renderingbooks.Models.Book;
import com.example.renderingbooks.Services.BookService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
    @Autowired
    BookService bookService;

    @RequestMapping("/book/{id}")
    public String book(@PathVariable Long id, Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("books", book);
        return "index";
    }
}
