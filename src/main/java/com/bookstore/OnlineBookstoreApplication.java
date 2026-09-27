package com.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class OnlineBookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookstoreApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void showUrl() {
        System.out.println();
        System.out.println("======================================");
        System.out.println(" Online Bookstore Started Successfully");
        System.out.println(" Open: http://localhost:8081");
        System.out.println("======================================");
    }
}