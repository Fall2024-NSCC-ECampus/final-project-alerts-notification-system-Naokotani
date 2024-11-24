package com.example.alerts.mapper;

import com.example.alerts.dto.community_email.CommunityEmailDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommunityEmailMapper {
    CommunityEmailDto peopleToCommunityEmail(Person person);
}
