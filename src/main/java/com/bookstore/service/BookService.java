package com.bookstore.service;

import com.bookstore.dao.BookDAO;
import com.bookstore.model.Book;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookDAO dao;
    public BookService(BookDAO dao) { this.dao = dao; }
    public List<Book> getBooks(String search) {
        return search == null || search.isBlank() ? dao.findAll() : dao.search(search.trim());
    }
    public Book getBook(long id) { return dao.findById(id); }
}
