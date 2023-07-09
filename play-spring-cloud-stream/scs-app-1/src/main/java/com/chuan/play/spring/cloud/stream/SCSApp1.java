package com.chuan.play.spring.cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Supplier;

@SpringBootApplication
public class SCSApp1 {

    public static void main(String[] args) {
        SpringApplication.run(SCSApp1.class, args);
    }

    @Bean
    public Supplier<Person> supplyPerson() {
        return () -> new Person("ZhangSan", 18, true);
    }

}
