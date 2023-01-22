package com.tweteroo.api.api.models;

import com.tweteroo.api.dtos.PersonDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Person {

    public Person(PersonDTO user) {
        this.username = user.username();
        this.avatar = user.avatar();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 100, nullable = false)
    private String username;

    @Column(length = 200, nullable = false)
    private String avatar;
}