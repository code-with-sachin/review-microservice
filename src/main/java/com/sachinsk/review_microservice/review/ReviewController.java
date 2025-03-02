package com.sachinsk.review_microservice.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(companyId, review);
        if (isReviewSaved) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Review not saved! As related Company does not exist", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewsById(@PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReviewById(reviewId), HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review updatedReview) {
        boolean isReviewUpdated = reviewService.updateReviewById(reviewId, updatedReview);
        if (isReviewUpdated) {
            return new ResponseEntity<>("Review updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review update action failed!", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        boolean isReviewDeleted = reviewService.deleteReviewById(reviewId);
        if (isReviewDeleted) {
            return new ResponseEntity<>("Review deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Review delete action failed!", HttpStatus.NOT_FOUND);
        }
    }


    /*
   GET /reviews?companyId={companyId}
   POST /reviews?companyId={companyId}
   GET /reviews/{reviewId}
   PUT /reviews/{reviewId}
   DELETE /reviews/{reviewId}

     */
}
