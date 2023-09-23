package com.barradas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HotelReserveApplication {

    public static void main(String[] args) {
        SpringApplication.run(HotelReserveApplication.class, args);
    }

}
