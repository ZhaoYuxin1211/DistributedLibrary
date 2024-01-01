package com.ucd.reviewservice.controller;


import com.ucd.reviewservice.dto.ReviewRequest;
import com.ucd.reviewservice.dto.ReviewResponse;
import com.ucd.reviewservice.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean createReview(@RequestBody ReviewRequest reviewRequest){
        return reviewService.createReview(reviewRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getReviewByBook(long bookId){
        return reviewService.getReviewByBook(bookId);
    }
}
