package com.example.dozermapper.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen {

    private String firstname;
    private String lastname;
    private Integer age;
    private String profession;
    private int experience;
    private BigDecimal salary;
}
