package com.tweteroo.api.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweteroo.api.api.models.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
    List<Person> findByUsername(String username);
}
