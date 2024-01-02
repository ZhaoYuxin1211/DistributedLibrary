package com.ucd.messageservice;

import com.ucd.messageservice.event.CheckoutEvent;
import com.ucd.messageservice.event.ReturnEvent;
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

    @KafkaListener(topics = "checkoutTopic", groupId = "checkoutId")
    public void handleCheckoutMessage(CheckoutEvent checkoutEvent){
        // send message to users?
        //TO DO
        log.info("User {} checkouted book {}", checkoutEvent.getUserEmail(), checkoutEvent.getTitle());
    }

    @KafkaListener(topics = "returnTopic", groupId = "returnId")
    public void handleReturnMessage(ReturnEvent returnEvent){
        // send message to users?
        //TO DO
        log.info("User {} returned book {}", returnEvent.getUserEmail(), returnEvent.getTitle());
    }
}
