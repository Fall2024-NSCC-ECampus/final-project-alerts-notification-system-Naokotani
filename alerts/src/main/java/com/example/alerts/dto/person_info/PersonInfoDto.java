package com.example.alerts.dto.person_info;

import lombok.Data;

import java.util.List;

@Data
public class PersonInfoDto {
    private List<PersonInfoPersonDto> people;
    private long numberOfChildren;
    private long numberOfAdults;

    public PersonInfoDto(List<PersonInfoPersonDto> people, long numberOfChildren, long numberOfAdults) {
        this.people = people;
        this.numberOfChildren = numberOfChildren;
        this.numberOfAdults = numberOfAdults;
    }
}
