package com.example.springjdbc.mappers;

import com.example.springjdbc.domain.TeacherDTO;
import com.example.springjdbc.model.Teacher;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;


@Mapper( componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR )
@Component
public interface TeacherDataObjectMapper {

    @Mapping(source = "id", target = "id")
    TeacherDTO toDTO(Teacher teacherDAO);

    @Mapping(source = "id", target = "id")
    Teacher toDAO(TeacherDTO teacherDTO);
}
