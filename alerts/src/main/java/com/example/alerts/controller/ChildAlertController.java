package com.example.alerts.controller;

import com.example.alerts.dto.child_alert.ChildAlertDto;
import com.example.alerts.mapper.ChildAlertMapper;
import com.example.alerts.model.Address;
import com.example.alerts.model.Person;
import com.example.alerts.repository.AddressRepository;
import com.example.alerts.repository.FireStationRepository;
import com.example.alerts.repository.PersonRepository;
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
    private final AddressRepository addressRepository;

    public ChildAlertController(PersonRepository personRepository,
                                AddressRepository addressRepository) {
        this.personRepository = personRepository;
        this.addressRepository = addressRepository;
    }

    @GetMapping("/test")
    public ResponseEntity<List<Person>> childAlertTest() {
        List<Person> people = personRepository.findAll();
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    // TODO mostly working, move to service.
    @GetMapping
    public ResponseEntity<ChildAlertDto> getChildAlert(
            @RequestParam String streetNumber,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String province,
            @RequestParam String postalCode
    ) {
        Address address = addressRepository
                .findAddressBystreetNumberAndStreetAndCityAndProvinceAndPostalCode(
                        streetNumber,
                        street,
                        city,
                        province,
                        postalCode );
        if(address == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Person> people = personRepository.findPersonByAddress(address);
        List<Person> adults = new ArrayList<>();
        List<Person> children = new ArrayList<>();
        for (Person person : people) {
            if(person.getAge() < 18) {
                children.add(person);
            } else {
                adults.add(person);
            }
        }
        ChildAlertDto childAlertDto = ChildAlertMapper.INSTANCE.personsToChildAlertDto(children, adults);

        return new ResponseEntity<>(childAlertDto, HttpStatus.OK);
    }
}
