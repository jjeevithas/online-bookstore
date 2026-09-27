package com.bookstore.dao;

import com.bookstore.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewDAO {

    private final JdbcTemplate jdbcTemplate;

    public ReviewDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Add a review
    public int addReview(Review review) {

        String sql = """
                INSERT INTO reviews
                (book_id, username, comment, rating)
                VALUES (?, ?, ?, ?)
                """;

        return jdbcTemplate.update(
                sql,
                review.getBookId(),
                review.getUsername(),
                review.getComment(),
                review.getRating()
        );
    }

    // Get reviews for a book
    public List<Review> getReviewsByBookId(Long bookId) {

        String sql = """
                SELECT id, book_id, username, comment, rating
                FROM reviews
                WHERE book_id = ?
                ORDER BY id DESC
                """;

        return jdbcTemplate.query(sql, (rs, rowNum) -> {

            Review review = new Review();

            review.setId(rs.getLong("id"));
            review.setBookId(rs.getLong("book_id"));
            review.setUsername(rs.getString("username"));
            review.setComment(rs.getString("comment"));
            review.setRating(rs.getInt("rating"));

            return review;
        }, bookId);
    }
}