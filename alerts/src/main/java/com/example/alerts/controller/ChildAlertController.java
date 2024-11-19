package com.example.alerts.controller;

import com.example.alerts.model.Person;
import com.example.alerts.repository.FireStationRepository;
import com.example.alerts.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {

    private final PersonRepository personRepository;
    private final FireStationRepository fireStationRepository;

    public ChildAlertController(PersonRepository personRepository, FireStationRepository fireStationRepository) {
        this.personRepository = personRepository;
        this.fireStationRepository = fireStationRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getChildAlert() {
        List<Person> people = personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }
}
