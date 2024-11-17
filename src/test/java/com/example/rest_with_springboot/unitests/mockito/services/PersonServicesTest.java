package com.example.rest_with_springboot.unitests.mockito.services;


import com.example.rest_with_springboot.DTO.V1.PersonDTO;
import com.example.rest_with_springboot.model.PersonModel;
import com.example.rest_with_springboot.repositories.PersonRepositories;
import com.example.rest_with_springboot.services.PersonServices;
import com.example.rest_with_springboot.unitestes.mapper.mocks.MockPerson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
public class PersonServicesTest {

    MockPerson input;

    @InjectMocks
    private PersonServices service;

    @Mock
    PersonRepositories repository;

    @BeforeEach
    void setUpMocks() throws Exception {
        input = new MockPerson();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById(){
        PersonModel entity = input.mockEntity();
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        var result = service.findById(1L);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());
        System.out.println(result.toString());
        assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("First Name Test0", result.getName());
        assertEquals("Addres Test0", result.getAddress());
        assertEquals("Male", result.getGender());

    }

    @Test
    //@MockitoSettings(strictness = Strictness.LENIENT)
    void testCreate(){
        PersonModel entity = input.mockEntity(0);
        PersonModel persisted = input.mockEntity();
        persisted.setId(1L);

        PersonDTO dto = input.mockVO(0);
        dto.setKey(1L);


        when(repository.save(any(PersonModel.class))).thenReturn(persisted);

        var result = service.create(dto);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("First Name Test0", result.getName());
        assertEquals("Addres Test0", result.getAddress());
        assertEquals("Male", result.getGender());

    }

    @Test
    void testUpdate(){
        PersonModel entity = input.mockEntity(1);
        entity.setId(1L);
        PersonModel persisted = entity;
        persisted.setId(1L);

        PersonDTO dto = input.mockVO(1);
        dto.setKey(1L);

        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        when(repository.save(any(PersonModel.class))).thenReturn(persisted);

        var result = service.update(dto);

        assertNotNull(result);
        assertNotNull(result.getKey());
        assertNotNull(result.getLinks());

        assertTrue(result.toString().contains("links: [</person/1>;rel=\"self\"]"));
        assertEquals("First Name Test1", result.getName());
        assertEquals("Addres Test1", result.getAddress());
        assertEquals("Female", result.getGender());
    }

    @Test
    void testDelete(){
        PersonModel entity = input.mockEntity(1);
        entity.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(entity));
        service.delete(1L);


    }
}
