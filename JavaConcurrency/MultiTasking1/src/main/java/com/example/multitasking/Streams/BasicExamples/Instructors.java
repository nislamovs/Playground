package com.example.multitasking.Streams.BasicExamples;

import java.util.Arrays;
import java.util.List;

public class Instructors {

    public static List<Instructor> getAll() {
        Instructor instructor1 = Instructor.builder()
                .name("Mike")
                .yearsOfExperience(10)
                .title("Software developer")
                .gender("M")
                .onlineCourses(true)
                .courses(Arrays.asList("Java Programming", "C++ Programming", "Python programming"))
        .build();

        Instructor instructor2 = Instructor.builder()
                .name("Jenny")
                .yearsOfExperience(5)
                .title("Engineer")
                .gender("F")
                .onlineCourses(false)
                .courses(Arrays.asList("Golang", "Scala", "Unit testing"))
                .build();

        Instructor instructor3 = Instructor.builder()
                .name("Gene")
                .yearsOfExperience(6)
                .title("Manager")
                .gender("M")
                .onlineCourses(false)
                .courses(Arrays.asList("C++ Programming", "C Programming", "Python programming"))
                .build();

        Instructor instructor4 = Instructor.builder()
                .name("Antony")
                .yearsOfExperience(15)
                .title("Senior Developer")
                .gender("M")
                .onlineCourses(true)
                .courses(Arrays.asList("Java Programming", "Angular Programming", "React native"))
                .build();

        Instructor instructor5 = Instructor.builder()
                .name("Syed")
                .yearsOfExperience(15)
                .title("Principal Engineer")
                .gender("M")
                .onlineCourses(true)
                .courses(Arrays.asList("Java Programming", "Java multithreaded Programming", "React native"))
                .build();

        return Arrays.asList(instructor1, instructor2, instructor3, instructor4, instructor5);
    }
}
