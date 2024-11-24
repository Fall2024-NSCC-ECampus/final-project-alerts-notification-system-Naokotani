package com.example.alerts.mapper;

import com.example.alerts.dto.person_info.FireStationDto;
import com.example.alerts.dto.person_info.FireStationPersonDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FireStationMapper {
    FireStationPersonDto personToPersonAddressDto(Person person, String fullAddress);
    FireStationDto peopleToPersonInfoDto(List<FireStationPersonDto> people, long numberOfChildren, long numberOfAdults);
}
