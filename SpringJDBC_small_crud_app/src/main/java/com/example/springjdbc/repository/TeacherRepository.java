package com.example.springjdbc.repository;

import com.example.springjdbc.model.Teacher;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository {

    List<Teacher> findAll();

    Teacher getTeacherByEmail(String email);

    List<Teacher> findPage(Integer offset, Integer limit, String orderMethod, String orderField);

    Teacher findById(Integer teacherId);

    int insert(Teacher teacher);

    int update(Teacher teacher);

    int delete(Integer teacherId);
}
