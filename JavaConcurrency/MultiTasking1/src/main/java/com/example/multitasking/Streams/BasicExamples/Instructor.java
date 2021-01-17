package com.example.multitasking.Streams.BasicExamples;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Instructor {
    private String name;
    private Integer yearsOfExperience;
    private String title;
    private String gender;
    private boolean onlineCourses;
    private List<String> courses;
}