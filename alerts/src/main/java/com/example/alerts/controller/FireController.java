package com.example.alerts.controller;

import com.example.alerts.dto.fire.FireDto;
import com.example.alerts.exception.ResourceNotFound;
import com.example.alerts.mapper.FireMapper;
import com.example.alerts.model.Address;
import com.example.alerts.model.Person;
import com.example.alerts.repository.AddressRepository;
import com.example.alerts.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This URL should return the fire station number that services the provided address as well as a list of all of
 * the people living at the address. This list should include each person’s name, phone number, age,
 * medications with dosage, and allergies.
 */
@RestController
@RequestMapping("/fire")
public class FireController {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final FireMapper fireMapper;

    public FireController(AddressRepository addressRepository, PersonRepository personRepository) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
    }


    @GetMapping
    public ResponseEntity<List<FireDto>> fire(
            @RequestParam String streetNumber,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String province,
            @RequestParam String postalCode
    ) throws ResourceNotFound {
        Address address
                = addressRepository.findAddressBystreetNumberAndStreetAndCityAndProvinceAndPostalCode(
                        streetNumber, street, city, province, postalCode)
                .orElseThrow(() -> new ResourceNotFound("Address not found"));
        List<Person> people = personRepository.findPersonByAddress(address);
        List<FireDto> fireDtos =
                people.stream().map(p -> fireMapper.personToFireDto(p,
                        p.getFirstName() + " " + p.getLastName(),
                        p.getAddress().toString())).toList();
        return new ResponseEntity<>(fireDtos, HttpStatus.OK);
    }

}
