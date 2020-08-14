package com.example.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private LocalDate birthdate;
}
