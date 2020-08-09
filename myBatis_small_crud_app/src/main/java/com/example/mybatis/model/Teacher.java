package com.example.mybatis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private Date birthdate;
}
