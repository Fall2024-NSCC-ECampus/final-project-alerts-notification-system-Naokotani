package com.example.alerts.controller;

import com.example.alerts.model.Person;
import com.example.alerts.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/personInfo")
public class PersonInfoController {

    private final PersonRepository personRepository;

    public PersonInfoController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
