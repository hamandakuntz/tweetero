package com.tweteroo.api.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tweteroo.api.api.services.PersonService;
import com.tweteroo.api.dtos.PersonDTO;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth/")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("sign-up")
    public ResponseEntity<String> signUp(@RequestBody @Valid PersonDTO person) {
        var personExists = personService.searchUsername(person.username());
        if (personExists) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já existe");
        }
        personService.signUp(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("OK");
    }
}
