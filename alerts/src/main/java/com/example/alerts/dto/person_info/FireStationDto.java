package com.example.alerts.dto.person_info;

import lombok.Data;

import java.util.List;

@Data
public class FireStationDto {
    private List<FireStationPersonDto> people;
    private long numberOfChildren;
    private long numberOfAdults;

    public FireStationDto(List<FireStationPersonDto> people, long numberOfChildren, long numberOfAdults) {
        this.people = people;
        this.numberOfChildren = numberOfChildren;
        this.numberOfAdults = numberOfAdults;
    }
}
