package com.example.jdbcexample.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDAO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private Date birthdate;
    private Long class_id;
    private Long subject_id;
    private boolean isHead;
}
