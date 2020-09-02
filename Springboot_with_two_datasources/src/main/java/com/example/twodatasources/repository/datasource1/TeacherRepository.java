package com.example.twodatasources.repository.datasource1;

import com.example.twodatasources.model.datasource1.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
