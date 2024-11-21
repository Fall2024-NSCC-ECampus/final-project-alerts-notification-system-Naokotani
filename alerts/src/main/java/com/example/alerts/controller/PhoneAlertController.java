package com.example.alerts.controller;

import com.example.alerts.dto.phone_alert.PhoneAlertDto;
import com.example.alerts.mapper.PhoneAlertMapper;
import com.example.alerts.model.Person;
import com.example.alerts.repository.FireStationRepository;
import com.example.alerts.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *  This URL should return a list of phone numbers of each person within the fire
 *  station’s jurisdiction. We’ll  use this to send emergency text messages to
 *  specific households.
 */
@RestController
@RequestMapping("/phoneAlert")
public class PhoneAlertController {
    private final FireStationRepository fireStationRepository;
    private final PersonRepository personRepository;

    public PhoneAlertController(FireStationRepository fireStationRepository, PersonRepository personRepository) {
        this.fireStationRepository = fireStationRepository;
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<PhoneAlertDto>> getPhoneAlertNumbers(@RequestParam Long firestation){
         List<Person> people = personRepository.findPersonByFireStationId(firestation);
         List<PhoneAlertDto> phoneAlertDtos = people.stream().map(PhoneAlertMapper.INSTANCE::personToPhoneAlertDto).toList();
         return ResponseEntity.ok(phoneAlertDtos);
    }
}
