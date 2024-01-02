package com.ucd.userservice.service;

import com.ucd.userservice.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final WebClient.Builder webClientBuilder;

    public boolean createReview(ReviewRequest reviewRequest){
        //call review service, and check is book existed
        return Boolean.TRUE.equals(webClientBuilder.build().post()
                .uri("http://review-service/api/review")
                .body(Mono.just(reviewRequest), ReviewRequest.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }

    public List<ReviewResponse> getReviewOnBook(long bookId){
        ReviewResponse[] reviewResponses = webClientBuilder.build().get()
                .uri("http://review-service/api/review",
                        uriBuilder -> uriBuilder.queryParam("bookId", bookId).build())
                .retrieve()
                .bodyToMono(ReviewResponse[].class)
                .block();
        return Arrays.stream(reviewResponses).toList();
    }


    public List<BookResponse> getAllBooks() {
        BookResponse[] bookResponses = webClientBuilder.build().get()
                .uri("http://book-service/api/book")
                .retrieve()
                .bodyToMono((BookResponse[].class))
                .block();
        List<BookResponse> responses = Arrays.stream(bookResponses).toList();
        return responses;
    }

    public boolean checkout(CheckoutRequest checkoutRequest){
        return Boolean.TRUE.equals(webClientBuilder.build().post()
                .uri("http://book-service/api/book/checkout")
                .body(Mono.just(checkoutRequest), CheckoutRequest.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }

    public boolean makeAReturn(ReturnRequest returnRequest) {
        return Boolean.TRUE.equals(webClientBuilder.build().post()
                .uri("http://book-service/api/book/return")
                .body(Mono.just(returnRequest), ReturnRequest.class)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block());
    }
}
