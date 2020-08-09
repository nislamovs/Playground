package com.example.mybatis.service;

import com.example.mybatis.domain.AbstractDTO;
import com.example.mybatis.domain.TeacherDTO;
import com.example.mybatis.mappers.TeacherDataObjectMapper;
import com.example.mybatis.model.Teacher;
import com.example.mybatis.repository.TeacherMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
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

    private final TeacherMapper teacherMapper;
    private final TeacherDataObjectMapper teacherDataObjectMapper;


    public List<TeacherDTO> getAllTeachers() {
        return teacherMapper.findAll().stream()
                .map(teacherDataObjectMapper::toDTO).collect(Collectors.toList());
    }

    public List<TeacherDTO> getTeachersPage(String pagenum, String pagesize, String sort, String group) {
        return teacherMapper.findPage(parseInt(pagenum) * parseInt(pagesize),  valueOf(pagesize), sort, group).stream()
                .map(teacherDataObjectMapper::toDTO).collect(Collectors.toList());
    }

    public TeacherDTO getTeacherById(String teacherId) {
        return teacherDataObjectMapper.toDTO(teacherMapper.findById(parseInt(teacherId)));
    }

    public TeacherDTO getTeacherByEmail(String email) {
        return teacherDataObjectMapper.toDTO(teacherMapper.getTeacherByEmail(email));
    }

    public AbstractDTO addNewTeacher(TeacherDTO newTeacher) {
        teacherMapper.insert(teacherDataObjectMapper.toDAO(newTeacher));

        return AbstractDTO.builder()
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO editTeacherData(TeacherDTO teacher) {
        teacherMapper.update(teacherDataObjectMapper.toDAO(teacher));

        return AbstractDTO.builder()
                .id(String.valueOf(teacher.getId()))
                .dateTime(LocalDateTime.now()).build();
    }

    public AbstractDTO deleteTeacher(String teacherId) {
        teacherMapper.delete(valueOf(teacherId));

        return AbstractDTO.builder().dateTime(LocalDateTime.now()).build();
    }
}
