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
public class SubjectMarkDAO {

    private Long id;
    private Long subject_id;
    private Long pupil_id;
    private Date date;
    private int value;
}
