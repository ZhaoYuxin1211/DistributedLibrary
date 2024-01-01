package com.ucd.messageservice;

import com.ucd.messageservice.event.CheckoutEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j
public class MessageServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MessageServiceApplication.class, args);
    }

    @KafkaListener(topics = "messageTopic")
    public void handleMessage(CheckoutEvent checkoutEvent){
        // send message to users?
        //TO DO
        log.info("User {} checkout book {}", checkoutEvent.getUserEmail(), checkoutEvent.getTitle());
    }
}
