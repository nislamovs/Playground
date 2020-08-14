package com.example.springjdbc.service;

import com.example.springjdbc.domain.AbstractDTO;
import com.example.springjdbc.domain.TeacherDTO;
import com.example.springjdbc.mappers.TeacherDataObjectMapper;
import com.example.springjdbc.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.valueOf;

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

    public List<TeacherDTO> getTeachersPage(String pagenum, String pagesize, String sort, String group) {
        return teacherRepository.findPage(parseInt(pagenum) * parseInt(pagesize),  valueOf(pagesize), sort, group).stream()
                .map(teacherDataObjectMapper::toDTO).collect(Collectors.toList());
    }

    public TeacherDTO getTeacherById(String teacherId) {
        return teacherDataObjectMapper.toDTO(teacherRepository.findById(parseInt(teacherId)));
    }

    public TeacherDTO getTeacherByEmail(String email) {
        return teacherDataObjectMapper.toDTO(teacherRepository.getTeacherByEmail(email));
    }

    public AbstractDTO addNewTeacher(TeacherDTO newTeacher) {
        teacherRepository.insert(teacherDataObjectMapper.toDAO(newTeacher));

        return AbstractDTO.builder()
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO editTeacherData(TeacherDTO teacher) {
        teacherRepository.update(teacherDataObjectMapper.toDAO(teacher));

        return AbstractDTO.builder()
                .id(String.valueOf(teacher.getId()))
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO deleteTeacher(String teacherId) {
        teacherRepository.delete(valueOf(teacherId));

        return AbstractDTO.builder().dateTime(LocalDateTime.now()).build();
    }
}
