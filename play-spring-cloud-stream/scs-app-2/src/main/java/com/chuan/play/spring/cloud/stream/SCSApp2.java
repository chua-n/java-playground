package com.chuan.play.spring.cloud.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class SCSApp2 {

    public static void main(String[] args) {
        SpringApplication.run(SCSApp2.class, args);
    }

    @Bean
    public Consumer<Person> consumePerson() {
        return person -> log.info("Received: " + person);
    }

}
