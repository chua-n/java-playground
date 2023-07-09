package com.chuan.play.spring.cloud.stream.controller;

import com.chuan.play.spring.cloud.stream.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

/**
 * @author xucy-e
 */
@RequestMapping("/scs")
@RestController
public class Controller {
    @Autowired
    private Supplier<Person> personSupplier;

    @PostMapping("/person")
    public void generateAMessage() {
        personSupplier.get();
    }
}
