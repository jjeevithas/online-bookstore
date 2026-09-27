
package com.bookstore.dao;

import com.bookstore.model.Book;
import com.bookstore.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDAO {

    private final JdbcTemplate jdbc;

    public CartDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<CartItem> findAll() {

        String sql = "SELECT c.id, c.book_id, c.quantity, " +
                     "b.title, b.author, b.description, b.price, " +
                     "b.image_url, b.category " +
                     "FROM cart_items c " +
                     "JOIN books b ON c.book_id = b.id " +
                     "ORDER BY c.id";

        return jdbc.query(sql, (rs, n) -> new CartItem(
                rs.getLong("id"),

                new Book(
                        rs.getLong("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("image_url"),
                        rs.getString("category")
                ),

                rs.getInt("quantity")
        ));
    }

    public void add(long bookId) {

        List<Integer> existing = jdbc.query(
                "SELECT quantity FROM cart_items WHERE book_id = ?",
                (rs, n) -> rs.getInt(1),
                bookId
        );

        if (existing.isEmpty()) {

            jdbc.update(
                    "INSERT INTO cart_items(book_id, quantity) VALUES(?, 1)",
                    bookId
            );

        } else {

            jdbc.update(
                    "UPDATE cart_items SET quantity = quantity + 1 WHERE book_id = ?",
                    bookId
            );
        }
    }

    public void remove(long id) {
        jdbc.update(
                "DELETE FROM cart_items WHERE id = ?",
                id
        );
    }

    public void clear() {
        jdbc.update("DELETE FROM cart_items");
    }
}

