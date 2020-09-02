package com.example.twodatasources.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TeacherDTO {

    private Integer id;

    private String firstname;

    private String lastname;

    private String email;

    private LocalDate birthdate;
}
