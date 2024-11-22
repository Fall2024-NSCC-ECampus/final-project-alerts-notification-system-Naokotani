package com.example.alerts.mapper;

import com.example.alerts.dto.flood.FloodDto;
import com.example.alerts.dto.flood.FloodPersonDto;
import com.example.alerts.model.Address;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FloodMapper {

    @Named("getFullName")
    default String getFullName(Person p) {
        return FormatFields.formatName(p);
    }

    @Named("getFullAddress")
    default String getFullAddress(Address a) {
        return FormatFields.formatAddress(a);
    }
    @Mapping(source="person.medication", target="medications")
    @Mapping(source="person.allergy", target="allergies")
    @Mapping(source="person", qualifiedByName = "getFullName", target="fullName")
    @Mapping(source="person.phone", target="phoneNumber")
    FloodPersonDto persontoFloodPersonDto(Person person);

    @Mapping(source="address", qualifiedByName = "getFullAddress", target="fullAddress")
    @Mapping(source="people", target="household")
    FloodDto peopleToFloodDto(Address address, List<FloodPersonDto> people);
}
