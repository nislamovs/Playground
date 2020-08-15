package com.example.flyway.repository;

import com.example.flyway.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Procedure(procedureName = "CREATE_TEACHER")
    int createBunchOfTeachers(int count);

}
