package com.bookstore.controller;

import com.bookstore.dao.ReviewDAO;
import com.bookstore.model.Review;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "*")
public class ReviewController {

    private final ReviewDAO reviewDAO;

    public ReviewController(ReviewDAO reviewDAO) {
        this.reviewDAO = reviewDAO;
    }

    // Add a review
    @PostMapping
    public String addReview(@RequestBody Review review) {

        if (review.getRating() < 1 || review.getRating() > 5) {
            return "Rating must be between 1 and 5";
        }

        reviewDAO.addReview(review);

        return "Review added successfully";
    }

    // Get reviews for a particular book
    @GetMapping("/book/{bookId}")
    public List<Review> getReviews(@PathVariable Long bookId) {

        return reviewDAO.getReviewsByBookId(bookId);
    }
}