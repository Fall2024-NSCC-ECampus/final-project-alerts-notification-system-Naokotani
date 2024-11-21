package com.example.alerts.controller;

import com.example.alerts.dto.child_alert.ChildAlertDto;
import com.example.alerts.exception.ResourceNotFound;
import com.example.alerts.mapper.ChildAlertMapper;
import com.example.alerts.model.Address;
import com.example.alerts.model.Person;
import com.example.alerts.repository.AddressRepository;
import com.example.alerts.repository.FireStationRepository;
import com.example.alerts.repository.PersonRepository;
import com.example.alerts.service.ChildAlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * This URL should return a list of children (anyone under the age of 18) at that address. The list should
 * include the first and last name of each child, the child’s age, and a list of other persons living at that
 * address. If there are no children at the address, then this URL can return an empty string.
 */
@RestController
@RequestMapping("/childAlert")
public class ChildAlertController {
    private final PersonRepository personRepository;
    private final ChildAlertService childAlertService;

    public ChildAlertController(PersonRepository personRepository,
                                 ChildAlertService childAlertService) {
        this.personRepository = personRepository;
        this.childAlertService = childAlertService;
    }

    @GetMapping("/test")
    public ResponseEntity<List<Person>> childAlertTest() {
        List<Person> people = personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    /**
     * Finds people by address and returns a breakdown of adults and children at address
     * @param streetNumber street number of the address
     * @param street street name of address
     * @param city city of address
     * @param province province of address
     * @param postalCode postal code of address
     * @return {@link ChildAlertDto} built from result of db query.
     * @throws ResourceNotFound throws if no matching address found.
     */
    @GetMapping
    public ResponseEntity<ChildAlertDto> getChildAlert(
            @RequestParam String streetNumber,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String province,
            @RequestParam String postalCode
    ) throws ResourceNotFound {
        return new ResponseEntity<>(childAlertService.getChildAlert(streetNumber,
                street, city, province, postalCode),
                HttpStatus.OK);
    }
}
