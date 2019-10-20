package com.lama.dal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@EnableMongoAuditing
@SpringBootApplication
public class DalApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DalApplication.class, args);
    }
}