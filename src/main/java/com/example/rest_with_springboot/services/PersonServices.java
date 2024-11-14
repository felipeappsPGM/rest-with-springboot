package com.example.rest_with_springboot.services;

import com.example.rest_with_springboot.model.PersonModel;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public PersonModel findById(String id) {
        logger.info("Findind one person");
        PersonModel person = new PersonModel();
        person.setId(counter.incrementAndGet());
        person.setName("felipe");
        person.setAddress("rua campo");
        person.setGender("machão");
        return person;
    }
}
