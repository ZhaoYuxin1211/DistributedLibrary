package com.ucd.bookservice;

import com.ucd.bookservice.model.Book;
import com.ucd.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
//@EnableEurekaClient
public class BookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookServiceApplication.class, args);
    }

@Bean
public CommandLineRunner loadData(BookRepository bookRepository) {
    return args -> {
        Book book1 = new Book(1,"JavaScript Cookbook", "Luv, Zofia", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin risus tortor, condimentum eget sapien ac, dapibus varius ligula. ", 10, 10, "FE", null);
        Book book2 = new Book(2, "Become a Guru in JavaScript", "Luv, Lena", "Pellentesque varius aliquam lacus quis rhoncus. Nam a dui lectus. Vestibulum libero elit, ultricies sit amet sagittis eu, molestie at velit. Donec tincidunt tempus magna, quis facilisis libero elementum non.", 15, 15, "FE", null);
        Book book3 = new Book(3, "Exploring Vue.js", "Luv, Jakub", "Proin at urna faucibus, pretium mi in, dapibus metus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam elementum ligula ut vestibulum tincidunt. ", 10, 10, "FE", null);
        Book book4 = new Book(4, "Advanced Techniques in Big Data", "Luv, Alexander", "Nunc eget lorem ac neque tincidunt mollis. Fusce finibus laoreet nunc nec hendrerit. Curabitur eu placerat urna, sit amet pellentesque enim.", 12, 12, "Data", null);

        List<Book> bookList = new ArrayList<>();
        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);
        bookList.add(book4);

        for (Book book : bookList){
            bookRepository.save(book);
        }
    };
}
}
