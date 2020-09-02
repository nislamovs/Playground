package com.example.twodatasources.converters;

import com.example.twodatasources.domain.PupilDTO;
import com.example.twodatasources.model.datasource2.Pupil;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Component
public interface PupilDataObjectMapper {

    @Mapping(source = "id", target = "id")
    PupilDTO toDTO(Pupil pupilDAO);

    @Mapping(source = "id", target = "id")
    Pupil toDAO(PupilDTO pupilDTO);
}
