package com.example.alerts.mapper;

import com.example.alerts.dto.person_info.PersonInfoDto;
import com.example.alerts.dto.person_info.PersonInfoPersonDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FireStationMapper {
    PersonInfoPersonDto personToPersonAddressDto(Person person, String fullAddress);
    PersonInfoDto peopleToPersonInfoDto(List<PersonInfoPersonDto> people, long numberOfChildren, long numberOfAdults);
}
