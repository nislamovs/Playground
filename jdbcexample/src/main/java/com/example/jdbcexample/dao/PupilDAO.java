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
public class PupilDAO {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String gender;
    private Date birthdate;
    private Long class_id;
    private Long class_head_id;
}
