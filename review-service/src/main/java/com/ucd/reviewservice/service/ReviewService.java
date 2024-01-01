package com.ucd.reviewservice.service;


import com.ucd.reviewservice.dto.ReviewRequest;
import com.ucd.reviewservice.dto.ReviewResponse;
import com.ucd.reviewservice.model.Review;
import com.ucd.reviewservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public boolean createReview(ReviewRequest reviewRequest) {
        Review review = Review.builder()
                .userEmail(reviewRequest.getUserEmail())
                .date(Date.valueOf(LocalDate.now()))
                .rating(reviewRequest.getRating())
                .bookId(reviewRequest.getBookId())
                .reviewDescription(reviewRequest.getReviewDescription())
                .build();
        reviewRepository.save(review);
        log.info("Review on book {} is saved.", review.getId());
        return true;
    }

    public List<ReviewResponse> getReviewByBook(long bookId){
        List<Review> reviewsByBookId = reviewRepository.findReviewsByBookId(bookId);

        List<ReviewResponse> reviewResponses = new ArrayList<>();
        for (Review review : reviewsByBookId){
            ReviewResponse reviewResponse = reviewToReviewResponse(review);
            reviewResponses.add(reviewResponse);
        }

        return reviewResponses;
    }

    public ReviewResponse reviewToReviewResponse(Review review){
        return ReviewResponse.builder()
                .id(review.getId())
                .userEmail(review.getUserEmail())
                .date(review.getDate())
                .rating(review.getRating())
                .bookId(review.getBookId())
                .reviewDescription(review.getReviewDescription())
                .build();
    }
}
