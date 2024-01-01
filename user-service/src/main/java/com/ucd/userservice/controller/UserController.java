package com.ucd.userservice.controller;

import com.ucd.userservice.dto.*;
import com.ucd.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks(){
        List<BookResponse> allBooks = userService.getAllBooks();
        return allBooks;
    }

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean makeACheckout(@RequestBody CheckoutRequest checkoutRequest){
        return userService.checkout(checkoutRequest);
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean makeAReturn(@RequestBody ReturnRequest returnRequest){
        return userService.makeAReturn(returnRequest);
    }

    @PostMapping("/review")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean review(@RequestBody ReviewRequest reviewRequest){
        return userService.createReview(reviewRequest);
    }

    @GetMapping("/getreview")
    @ResponseStatus(HttpStatus.OK)
    public List<ReviewResponse> getReviewOnBookId(@RequestParam long bookId){
        return userService.getReviewOnBook(bookId);
    }


}
