package com.example.alerts.mapper;

import com.example.alerts.dto.community_email.CommunityEmailDto;
import com.example.alerts.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CommunityEmailMapper {
    CommunityEmailMapper INSTANCE = Mappers.getMapper(CommunityEmailMapper.class);
    CommunityEmailDto peopleToCommunityEmail(Person person);
}
