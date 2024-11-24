package com.example.alerts.mapper;


import com.example.alerts.dto.fire.FireDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FireMapper {
    @Mapping(source="person.medication", target="medications")
    @Mapping(source="person.allergy", target="allergies")
    @Mapping(source="name", target="fullName")
    @Mapping(source="person.phone", target="phoneNumber")
    FireDto personToFireDto(Person person, String name, String fullAddress);
}
