package com.bookstore.dao;

import com.bookstore.model.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAO {

    private final JdbcTemplate jdbc;

    public BookDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private final org.springframework.jdbc.core.RowMapper<Book> mapper =
            (rs, rowNum) -> {
                Book book = new Book();

                book.setId(rs.getLong("id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setDescription(rs.getString("description"));
                book.setPrice(rs.getDouble("price"));
                book.setImageUrl(rs.getString("image_url"));
                book.setCategory(rs.getString("category"));

                return book;
            };

    public List<Book> findAll() {
        return jdbc.query(
                "SELECT * FROM books ORDER BY id",
                mapper
        );
    }

    public List<Book> search(String keyword) {
        return jdbc.query(
                "SELECT * FROM books WHERE title ILIKE ? OR author ILIKE ? ORDER BY id",
                mapper,
                "%" + keyword + "%",
                "%" + keyword + "%"
        );
    }

    public Book findById(long id) {
        return jdbc.queryForObject(
                "SELECT * FROM books WHERE id = ?",
                mapper,
                id
        );
    }
}