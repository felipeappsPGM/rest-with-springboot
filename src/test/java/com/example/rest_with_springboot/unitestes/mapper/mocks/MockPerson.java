package com.example.rest_with_springboot.unitestes.mapper.mocks;

import java.util.ArrayList;
import java.util.List;


import com.example.rest_with_springboot.DTO.V1.PersonDTO;
import com.example.rest_with_springboot.model.PersonModel;

public class MockPerson {


    public PersonModel mockEntity() {
        return mockEntity(0);
    }
    
    public PersonDTO mockVO() {
        return mockVO(0);
    }
    
    public List<PersonModel> mockEntityList() {
        List<PersonModel> persons = new ArrayList<PersonModel>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonDTO> mockVOList() {
        List<PersonDTO> persons = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            persons.add(mockVO(i));
        }
        return persons;
    }
    
    public PersonModel mockEntity(Integer number) {
        PersonModel person = new PersonModel();
        person.setAddress("Addres Test" + number);
        person.setName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setId(number.longValue());
        return person;
    }

    public PersonDTO mockVO(Integer number) {
        PersonDTO person = new PersonDTO();
        person.setAddress("Addres Test" + number);
        person.setName("First Name Test" + number);
        person.setGender(((number % 2)==0) ? "Male" : "Female");
        person.setKey(number.longValue());
        return person;
    }

}
