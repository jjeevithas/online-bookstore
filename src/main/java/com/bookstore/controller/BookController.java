package com.bookstore.controller;

import com.bookstore.model.Book;
import com.bookstore.service.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {
    private final BookService service;
    public BookController(BookService service) { this.service = service; }

    @GetMapping
    public List<Book> books(@RequestParam(required=false) String search) {
        return service.getBooks(search);
    }

    @GetMapping("/{id}")
    public Book book(@PathVariable long id) {
        return service.getBook(id);
    }
}
