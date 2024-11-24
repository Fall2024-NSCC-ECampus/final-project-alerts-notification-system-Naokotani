package com.example.alerts.mapper;

import com.example.alerts.dto.flood.FloodDto;
import com.example.alerts.dto.flood.FloodPersonDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FloodMapper {
    default String fullNameMap(Person p) {
        return p.getFirstName() + " " + p.getLastName();
    }

    @Mapping(source="person.medication", target="medications")
    @Mapping(source="person.allergy", target="allergies")
    @Mapping(source=".", target="fullName")
    @Mapping(source="person.phone", target="phoneNumber")
    FloodPersonDto persontoFloodPersonDto(Person person);

    @Mapping(source="address", target="fullAddress")
    @Mapping(source="people", target="household")
    FloodDto peopleToFloodDto(String address, List<FloodPersonDto> people);
}
