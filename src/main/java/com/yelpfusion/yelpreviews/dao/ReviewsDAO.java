package com.yelpfusion.yelpreviews.dao;

import com.yelpfusion.yelpreviews.dto.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewsDAO {
    private List<Review> reviews = new ArrayList<>();

    /*
     * Adds a new review to the list of reviews.
     *
     * @oaram review the review object to add.
     * @return The review object added.
     */
    public Review addReview(Review review) {
        reviews.add(review);

        return review;
    }

    /*
     * Gets the list of reviews.
     *
     * @return The review list.
     */
    public List<Review> getReviews() {
        return reviews;
    }
}
