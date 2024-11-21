package com.example.alerts.mapper;


import com.example.alerts.dto.fire.FireDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FireMapper {
    // TODO remove, do the bean way
    FireMapper INSTANCE = Mappers.getMapper(FireMapper.class);
    @Mapping(source="person.medication", target="medications")
    @Mapping(source="person.allergy", target="allergies")
    @Mapping(source="name", target="fullName")
    @Mapping(source="person.phone", target="phoneNumber")
    FireDto personToFireDto(Person person, String name, String fullAddress);
}
