package com.example.alerts.mapper;

import com.example.alerts.dto.child_alert.ChildAlertDto;
import com.example.alerts.dto.child_alert.ChildAlertPersonDto;
import com.example.alerts.dto.phone_alert.PhoneAlertDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import javax.xml.transform.Source;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PhoneAlertMapper {
    // TODO remove and do the bean way
    PhoneAlertMapper INSTANCE = Mappers.getMapper( PhoneAlertMapper.class );

    @Mapping(target="fullName", source=".")
    @Mapping(source="person.phone", target="phoneNumber")
    PhoneAlertDto personToPhoneAlertDto(Person person);

    default String getFullName(Person p) {
        return p.getFirstName() + " " + p.getLastName();
    }
}
