package com.example.booksapi.Services;

import com.example.booksapi.Models.Book;
import com.example.booksapi.Repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    // adding the book repository as a dependency
    @Autowired
    BookRepository bookRepository;
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        return optionalBook.orElse(null);
    }

    public Book updateBook(Long id,String title,String description,String language,Integer numOfPages) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        Book book = optionalBook.orElse(null);
        book.setTitle(title);
        book.setDescription(description);
        book.setLanguage(language);
        book.setNumberOfPages(numOfPages);
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}