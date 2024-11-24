package com.example.alerts.controller;

import com.example.alerts.dto.flood.FloodDto;
import com.example.alerts.dto.flood.FloodPersonDto;
import com.example.alerts.mapper.FloodMapper;
import com.example.alerts.model.Address;
import com.example.alerts.model.FireStation;
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

import java.util.List;
import java.util.stream.Collectors;

/**
 * This should return a list of all the households in each fire station’s
 * jurisdiction. This list needs to group people by household address, including
 * name, phone number, and age of each person, and any medications (with dosages)
 * and allergies beside each person’s name.
*/

@RestController
@RequestMapping("/flood")
public class FloodController {
    private final AddressRepository addressRepository;
    private final PersonRepository personRepository;
    private final FloodMapper floodMapper;

    public FloodController(AddressRepository addressRepository, PersonRepository personRepository, FloodMapper floodMapper) {
        this.addressRepository = addressRepository;
        this.personRepository = personRepository;
        this.floodMapper = floodMapper;
    }

    @GetMapping
    public ResponseEntity<List<FloodDto>> getFloodHouseholds(@RequestParam List<Long> stations) {
        // TODO 404?
        List<Address> addresses = stations.stream()
                .flatMap(s-> addressRepository.findAddressByStation(s).stream()).toList();
        List<FloodDto> floodDtos = addresses.stream()
                .map(address -> {
                    List<Person> people = personRepository.findPersonByAddress(address);
                    return FloodMapper.INSTANCE.peopleToFloodDto(
                            address.toString(),
                            people.stream()
                                    .map(floodMapper::persontoFloodPersonDto)
                                    .collect(Collectors.toList())
                    );
                }).toList();
        return new ResponseEntity<>(floodDtos, HttpStatus.OK);
    }
}
