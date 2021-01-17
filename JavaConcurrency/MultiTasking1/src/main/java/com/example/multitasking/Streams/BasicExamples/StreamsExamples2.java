package com.example.multitasking.Streams.BasicExamples;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExamples2 {
    public static void main(String[] args) {

        //creating a map of names and course of instructors who teaches
        //online have more than 10 years of experience

        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses();
        Predicate<Instructor> p2 = (i) -> i.getYearsOfExperience() > 10;

        List<Instructor> list = Instructors.getAll();

        Map<String, List<String>> map = list.stream()
                .filter(p1)
                .peek(System.out::println)
                .filter(p2)
                .collect(Collectors.toMap(Instructor::getName, Instructor::getCourses));


        System.out.println("\n\n");
        System.out.println(map);
    }
}
