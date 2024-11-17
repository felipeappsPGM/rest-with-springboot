package com.example.rest_with_springboot.services;

import com.example.rest_with_springboot.DTO.V1.PersonDTO;
import com.example.rest_with_springboot.DTO.V2.PersonDTOV2;
import com.example.rest_with_springboot.controller.PersonController;
import com.example.rest_with_springboot.exceptions.RequiredIsNullException;
import com.example.rest_with_springboot.exceptions.ResourceNotFoundException;
import com.example.rest_with_springboot.mapper.DozerMapper;
import com.example.rest_with_springboot.mapper.custom.PersonMapper;
import com.example.rest_with_springboot.model.PersonModel;
import com.example.rest_with_springboot.repositories.PersonRepositories;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonServices {

    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    PersonRepositories repository;
    PersonMapper mapper;

    public PersonServices(PersonRepositories repository, PersonMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public PersonDTO findById(Long id) {
        logger.info("Findind one person");

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for ID: " + id));

        var dto = DozerMapper.parseObject(entity, PersonDTO.class);
        dto.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
        return dto;
    }

    public List<PersonDTO> findAll() {
        logger.info("Findind all people");

        var persons = DozerMapper.parseListObjects(repository.findAll(), PersonDTO.class);

        persons.forEach(p -> p.add(linkTo(methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));

        return persons;

    }


    public PersonDTO create(PersonDTO person) {
        if (person == null) {
            throw new RequiredIsNullException();
        }
        logger.info("Creating one person model");

        var entity = DozerMapper.parseObject(person, PersonModel.class  );
        var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);
        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;

    }

    public PersonDTOV2 createV2(PersonDTOV2 person) {
        if (person == null) {
            throw new RequiredIsNullException();
        }
        logger.info("Creating one person mode with v2");

        var entity = mapper.convertDTOToEntity(person );
        var dto = mapper.convertEntityToDTO(repository.save(entity));

        return dto;
    }

    public PersonDTO update(PersonDTO person) {
        if (person == null) {
            throw new RequiredIsNullException();
        }
        logger.info("Updating one person model");

        var entity = repository.findById(person.getKey()).orElseThrow(() -> new ResourceNotFoundException("id not found"));

        entity.setName(person.getName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        var dto = DozerMapper.parseObject(repository.save(entity), PersonDTO.class);


        dto.add(linkTo(methodOn(PersonController.class).findById(dto.getKey())).withSelfRel());
        return dto;

    }

    public void delete(Long id) {
        logger.info("Delete one person model com id: " + id);

        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("id not found"));

        repository.delete(entity);
    }
}
