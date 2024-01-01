package com.ucd.bookservice.service;

import com.ucd.bookservice.dao.BookResponse;
import com.ucd.bookservice.dao.CheckoutRequest;
import com.ucd.bookservice.dao.ReturnRequest;
import com.ucd.bookservice.event.CheckoutEvent;
import com.ucd.bookservice.model.Book;
import com.ucd.bookservice.model.CheckOut;
import com.ucd.bookservice.model.Return;
import com.ucd.bookservice.repository.BookRepository;
import com.ucd.bookservice.repository.CheckoutRepository;
import com.ucd.bookservice.repository.ReturnRepository;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
@Builder
public class BookService {
    private final BookRepository bookRepository;
    private final CheckoutRepository checkoutRepository;
    private final ReturnRepository returnRepository;
    private final KafkaTemplate<String, CheckoutEvent> checkoutKafkaTemplate;

    public List<BookResponse> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        List<BookResponse> bookResponses = new ArrayList<>();

        for(Book book : bookList){
            BookResponse bookResponse = mapToBookResponse(book);
            bookResponses.add(bookResponse);
        }
        return bookResponses;
    }

    @Transactional
    public boolean checkOut(CheckoutRequest checkoutRequest){
        //check if the book still has stock
        boolean inStock = isInStock(checkoutRequest.getBookId());
        if (inStock){
            //update the stock
            Book book = bookRepository.getReferenceById(checkoutRequest.getBookId());
            book.setCopiesAvailable(book.getCopiesAvailable()-1);
            bookRepository.save(book);

            //create new record of checkout
            CheckOut checkOut = CheckOut.builder()
                    .userEmail(checkoutRequest.getUserEmail())
                    .bookId(checkoutRequest.getBookId())
                    .checkoutDate(Date.valueOf(LocalDate.now()))
                    .build();
            checkoutRepository.save(checkOut);

            //send message to the user that the book has been succussfully checked out
            // *asynchronous
            checkoutKafkaTemplate.send("messageTopic", new CheckoutEvent(checkOut.getId(), checkOut.getUserEmail(), book.getTitle()));
            return true;
        }else {
            log.info("The book is out of stock.");
            return false;
        }
    }

    @Transactional
    public boolean returnBook(ReturnRequest returnRequest){
        // update the book stock
        Book book = bookRepository.getReferenceById(returnRequest.getBookId());
        book.setCopiesAvailable(book.getCopiesAvailable()+1);
        if (book.getCopies() < book.getCopiesAvailable()){
            log.info("Error!");
            return false;
        }else {
            bookRepository.save(book);
            // create a return record
            Return aReturn = Return.builder()
                    .returnDate(Date.valueOf(LocalDate.now()))
                    .userEmail(returnRequest.getUserEmail())
                    .bookId(returnRequest.getBookId())
                    .build();
            returnRepository.save(aReturn);
            return true;
        }
    }

    @Transactional(readOnly = true)
    public boolean isInStock(long bookIds){
        Book book = bookRepository.getReferenceById(bookIds);
        int stock = book.getCopiesAvailable();
        if (stock == 0){
            return false;
        }else {
            return true;
        }
    }

    private BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .category(book.getCategory())
                .copies(book.getCopies())
                .description(book.getDescription())
                .img(book.getImg())
                .build();
    }
}
