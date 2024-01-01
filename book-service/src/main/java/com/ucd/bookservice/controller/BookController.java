package com.ucd.bookservice.controller;


import com.ucd.bookservice.dao.BookResponse;
import com.ucd.bookservice.dao.CheckoutRequest;
import com.ucd.bookservice.dao.ReturnRequest;
import com.ucd.bookservice.repository.CheckoutRepository;
import com.ucd.bookservice.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final CheckoutRepository checkoutRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookResponse> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/stocking")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam Long bookId) {
        return bookService.isInStock(bookId);
    }

    @PostMapping("/checkout")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean checkOut(@RequestBody CheckoutRequest checkoutRequest) {
        return bookService.checkOut(checkoutRequest);
    }

    @PostMapping("/return")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public boolean returnBook(@RequestBody ReturnRequest returnRequest) {
        return bookService.returnBook(returnRequest);
    }

}
