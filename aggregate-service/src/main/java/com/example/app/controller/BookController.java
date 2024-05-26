package com.example.app.controller;

import com.example.app.library.BookAllResponse;
import com.example.app.model.BookResponse;
import com.example.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 10/18/2023
 * 6:11 PM
 */

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<BookResponse> getAllBooks(){
        System.out.println("bookService = " + bookService.getAllBooks());
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }
}
