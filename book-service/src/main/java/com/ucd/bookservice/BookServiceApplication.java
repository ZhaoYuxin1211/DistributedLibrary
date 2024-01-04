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
        Book book1 = new Book(1,"Yellowface", "R.F. Kuang", "With its totally immersive first-person voice, Yellowface grapples with questions of diversity, racism, and cultural appropriation, as well as the terrifying alienation of social media. R.F. Kuang’s novel is timely, razor-sharp, and eminently readable.", 10, 10, "FE", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1671336608i/62047984.jpg");

        Book book2 = new Book(2, "Hello Beautiful", "Ann Napolitano", "Vibrating with tenderness, Hello Beautiful is a gorgeous, profoundly moving portrait of what’s possible when we choose to love someone not in spite of who they are, but because of it. ", 15, 15, "FE", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1687803098i/61771675.jpg");

        Book book3 = new Book(3, "Someone Else's Shoes", "Jojo Moyes", "Proin at urna faucibus, pretium mi in, dapibus metus. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam elementum ligula ut vestibulum tincidunt. ", 10, 10, "FE", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1666822989i/62971668.jpg");

        Book book4 = new Book(4, "The Collected Regrets of Clover", "Mikki Brammer", "Probing, clever, and hopeful, The Collected Regrets of Clover is perfect for readers of The Midnight Library and Eleanor Oliphant is Completely Fine as it turns the normally taboo subject of death into a reason to celebrate life.", 12, 12, "Data", "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1663608724i/61214136.jpg");


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
