package com.example.alerts.controller;

import com.example.alerts.dto.person_info.PersonInfoDto;
import com.example.alerts.dto.person_info.PersonInfoPersonDto;
import com.example.alerts.mapper.FireStationMapper;
import com.example.alerts.model.Person;
import com.example.alerts.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This URL should return a list of people serviced by the corresponding fire station. So if station number = 1,
 * it should return the people serviced by station number 1. The list of people should include these specific
 * pieces of information: first name, last name, address, and phone number. As well, it should provide a
 * summary of the number of adults in the service area and the number of children (anyone aged 18 or younger).
*/
@RestController
@RequestMapping("/firestation")
public class FireStatinController {

    private final PersonRepository personRepository;
    private final FireStationMapper fireStationMapper;
    public FireStatinController(PersonRepository personRepository, FireStationMapper fireStationMapper) {
        this.personRepository = personRepository;
        this.fireStationMapper = fireStationMapper;
    }

    /**
     * Test function that returns a list of all people.
     * @return A list of a people in json format and http status 200
     */
    @GetMapping("/test")
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    // TODO Refactor to service
    // TODO correct query name?
    /**
     * Returns the list of people serviced by a fire station.
     * @param stationNumber The id of the fire station to return a list of people for.
     * @return A list of {@link Person}
     */
    @GetMapping()
    public ResponseEntity<PersonInfoDto> getPeopleByFireStation(@RequestParam Long stationNumber) {
        List<Person> people = personRepository.findPersonByFireStationId(stationNumber);
        long adults = people.stream().filter(p -> p.getAge() >= 18).count();
        long children = people.stream().filter(p -> p.getAge() < 18).count();
        List<PersonInfoPersonDto> personInfoPersonDto = people.stream()
                .map(p -> fireStationMapper.personToPersonAddressDto(p, p.getAddress().toString())).toList();
        PersonInfoDto personInfoDto
                = fireStationMapper.peopleToPersonInfoDto(personInfoPersonDto, children, adults);
        return new ResponseEntity<>(personInfoDto, HttpStatus.OK);
    }
}
