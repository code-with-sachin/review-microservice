package com.sachinsk.review_microservice.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);

    Review getReviewById(Long reviewId);

    boolean updateReviewById(Long reviewId, Review updatedReview);

    boolean deleteReviewById(Long reviewId);
}
