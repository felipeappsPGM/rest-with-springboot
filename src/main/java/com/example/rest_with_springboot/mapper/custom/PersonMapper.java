package com.example.rest_with_springboot.mapper.custom;

import com.example.rest_with_springboot.DTO.V2.PersonDTOV2;
import com.example.rest_with_springboot.model.PersonModel;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDTOV2 convertEntityToDTO(PersonModel person){
        PersonDTOV2 dto = new PersonDTOV2();
        dto.setName(person.getName());
        dto.setAddress(person.getAddress());
        dto.setBirthDate(new Date());
        dto.setGender(person.getGender());
        dto.setId(person.getId());

        return dto;
    }

    public PersonModel convertDTOToEntity(PersonDTOV2 person){
        PersonModel entity = new PersonModel();
        entity.setName(person.getName());
        entity.setAddress(person.getAddress());
        //entity.setBirthDate(new Date());
        entity.setGender(person.getGender());
        entity.setId(person.getId());

        return entity;
    }
}
