package com.example.rest_with_springboot.DTO.V1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Objects;


@JsonPropertyOrder({"id", "name", "address","gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable{

    private static final long serialVersionUID = 1L;
    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    @JsonProperty("name")
    private String name;
    //@JsonIgnore // usado para NÃOOOO ser enviado no serializer
    private String address;

    public PersonDTO() {
    }

    public PersonDTO(Long key, String name, String address, String gender) {
        this.key = key;
        this.name = name;
        this.address = address;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PersonDTO personDTO = (PersonDTO) o;
        return Objects.equals(key, personDTO.key) && Objects.equals(name, personDTO.name) && Objects.equals(address, personDTO.address) && Objects.equals(gender, personDTO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, name, address, gender);
    }

    private String gender;

    public void setKey(Long key) {
        this.key = key;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Long getKey() {
        return key;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }
}
