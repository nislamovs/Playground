package com.example.twodatasources.services;


import com.example.twodatasources.converters.TeacherDataObjectMapper;
import com.example.twodatasources.domain.AbstractDTO;
import com.example.twodatasources.domain.TeacherDTO;
import com.example.twodatasources.repository.datasource1.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Long.parseLong;

@Service
@Slf4j
@RequiredArgsConstructor
public class TeachersService {

    private final TeacherRepository teacherRepository;
    private final TeacherDataObjectMapper teacherDataObjectMapper;

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream()
                .map(teacherDataObjectMapper::toDTO).collect(Collectors.toList());
    }

    public TeacherDTO getTeacherById(String teacherId) {
        return teacherDataObjectMapper.toDTO(teacherRepository.findById(parseLong(teacherId)).get());
    }

    public AbstractDTO addNewTeacher(TeacherDTO newTeacher) {
        teacherRepository.save(teacherDataObjectMapper.toDAO(newTeacher));

        return AbstractDTO.builder()
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO editTeacherData(TeacherDTO teacher) {
        teacherRepository.save(teacherDataObjectMapper.toDAO(teacher));

        return AbstractDTO.builder()
                .id(String.valueOf(teacher.getId()))
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO deleteTeacher(String teacherId) {
        teacherRepository.deleteById(parseLong(teacherId));

        return AbstractDTO.builder().dateTime(LocalDateTime.now()).build();
    }
}
