package com.example.rest_with_springboot.controller;

import com.example.rest_with_springboot.DTO.V1.PersonDTO;
import com.example.rest_with_springboot.DTO.V2.PersonDTOV2;
import com.example.rest_with_springboot.model.PersonModel;
import com.example.rest_with_springboot.services.PersonServices;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonServices service;

    public PersonController(PersonServices service) {
        this.service = service;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO findById(
            @PathVariable(value = "id") Long id
            ){
        return service.findById(id);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PersonDTO> findAll(
    ){
        return service.findAll();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO create(@RequestBody PersonDTO person
    ){
        return service.create(person);
    }

    @PostMapping(value = "/v2", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 person
    ){
        return service.createV2(person);
    }

    @PutMapping( produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PersonDTO update(@RequestBody PersonDTO person
    ){
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteOnePerson(
            @PathVariable(value = "id") Long id
    ){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
