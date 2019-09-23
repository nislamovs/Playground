package com.example.dozermapper.beans;

import lombok.*;
import org.dozer.Mapping;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Developer {

    @Mapping("firstname")
    private String name;
    @Mapping("lastname")
    private String surname;
    @Mapping("age")
    private String age;
    @Mapping("profession")
    private String speciality;
    @Mapping("experience")
    private String experience;
    @Mapping("salary")
    private String salary;
}
