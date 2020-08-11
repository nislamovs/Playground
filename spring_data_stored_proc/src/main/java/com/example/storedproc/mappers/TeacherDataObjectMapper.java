package com.example.storedproc.mappers;

import com.example.storedproc.domain.TeacherDTO;
import com.example.storedproc.model.Teacher;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
@Component
public interface TeacherDataObjectMapper {

    @Mapping(source = "id", target = "id")
    TeacherDTO toDTO(Teacher teacherDAO);

    @Mapping(source = "id", target = "id")
    Teacher toDAO(TeacherDTO teacherDTO);
}
