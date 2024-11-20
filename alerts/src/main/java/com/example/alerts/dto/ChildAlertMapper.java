package com.example.alerts.dto;

import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ChildAlertMapper {
    ChildAlertMapper INSTANCE = Mappers.getMapper( ChildAlertMapper.class );

    PersonDto personToPersonDto(Person person);
    ChildAlertDto personsToChildAlertDto(List<Person> children, List<Person> adults);
}
