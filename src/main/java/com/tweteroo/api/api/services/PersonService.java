package com.tweteroo.api.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweteroo.api.api.models.Person;
import com.tweteroo.api.api.repositories.PersonRepository;
import com.tweteroo.api.dtos.PersonDTO;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    public void signUp(PersonDTO person) {      
        personRepository.save(new Person(person));
    }

    public boolean searchUsername(String username) {
        List<Person> person = personRepository.findByUsername(username);
        
        if(!person.isEmpty()) {
            return true;
        }
        return false;
    }
}
