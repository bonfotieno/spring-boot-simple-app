package com.bonfaceapps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //replaces @ComponentScan(basePackages = "com.bonfaceapps") and @EnableAutoConfiguration
public class Main {
    public static void main(String[] args) {
         SpringApplication.run(Main.class, args);
        }
}
