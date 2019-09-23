package com.example.dozermapper.beans;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    private String name;
    private String surname;
    private String birthYear;
    private String speciality;
    private String experience;
    private String salary;
}
