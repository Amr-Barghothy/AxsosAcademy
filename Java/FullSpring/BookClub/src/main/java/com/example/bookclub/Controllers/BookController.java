package com.example.bookclub.Controllers;

import com.example.bookclub.Models.Book;
import com.example.bookclub.Models.User;
import com.example.bookclub.Services.BookService;
import com.example.bookclub.Services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    BookService bookService;
    @Autowired
    UserService userService;

    @GetMapping("/books")
    public String books(Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("user_id") == null) {
            redirectAttributes.addFlashAttribute("error", "You must login or register first");
            return "redirect:/";
        }
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("user", userService.findById((Long)session.getAttribute("user_id")));
        return "allBooks";
    }

    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book,HttpSession session,RedirectAttributes redirectAttributes) {
        if (session.getAttribute("user_id") == null) {
            redirectAttributes.addFlashAttribute("error", "You must login or register first");
            return "redirect:/";
        }
        return "newBook";
    }

    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, HttpSession session, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "newBook";
        }
        if (session.getAttribute("user_id") == null) {
            redirectAttributes.addFlashAttribute("error", "You must login or register first");
            return "redirect:/";
        }
        User user = userService.findById((Long)session.getAttribute("user_id"));
        System.out.println(user.getName());
        bookService.createBook(book,user);
        return "redirect:/books";
    }

    @GetMapping("/books/{book_id}")
    public String editBook(@PathVariable Long book_id, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("user_id") == null) {
            redirectAttributes.addFlashAttribute("error", "You must login or register first");
            return "redirect:/";
        }
        model.addAttribute("book",bookService.getBookById(book_id));
        return "details";
    }
}
