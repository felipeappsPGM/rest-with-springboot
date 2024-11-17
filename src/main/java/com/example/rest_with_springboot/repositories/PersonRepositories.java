package com.example.rest_with_springboot.repositories;

import com.example.rest_with_springboot.model.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositories extends JpaRepository<PersonModel, Long> {
}
