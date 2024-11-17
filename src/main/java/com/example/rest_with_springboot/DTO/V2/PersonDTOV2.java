package com.example.rest_with_springboot.DTO.V2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class PersonDTOV2 implements Serializable{

    private static final long serialVersionUID = 1L;
    private Long id;
    private String name;
    private String address;
    private String gender;
    private Date birthDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public PersonDTOV2() {
    }

    public Long getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public PersonDTOV2(Long id, String name, String address, String gender, Date birthDate) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonDTOV2 that = (PersonDTOV2) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(gender, that.gender) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, gender, birthDate);
    }
}
