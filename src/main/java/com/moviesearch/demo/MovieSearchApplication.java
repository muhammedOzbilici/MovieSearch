package com.moviesearch.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MovieSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieSearchApplication.class, args);
    }

}
