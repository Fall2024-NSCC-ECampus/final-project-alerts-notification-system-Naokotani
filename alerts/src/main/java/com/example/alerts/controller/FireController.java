package com.example.alerts.controller;

import com.example.alerts.dto.AddressDto;
import com.example.alerts.dto.fire.FireDto;
import com.example.alerts.exception.ResourceNotFound;
import com.example.alerts.model.Address;
import com.example.alerts.repository.AddressRepository;
import com.example.alerts.service.FireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private final FireService fireService;

    public FireController(AddressRepository addressRepository, FireService fireService) {
        this.addressRepository = addressRepository;
        this.fireService = fireService;
    }

    @GetMapping
    public ResponseEntity<List<FireDto>> fire(@ModelAttribute AddressDto addressDto)
            throws ResourceNotFound {
        List<FireDto> fireDto = fireService.getFireList(addressDto);
        return new ResponseEntity<>(fireDto, HttpStatus.OK);
    }

}
