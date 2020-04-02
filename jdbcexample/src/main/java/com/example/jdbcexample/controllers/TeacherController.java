package com.example.jdbcexample.controllers;

import com.example.jdbcexample.dto.TeacherDTO;
import com.example.jdbcexample.services.TeachersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class TeacherController {

    private final TeachersService teachersService;

    @RequestMapping("/teacher/all")
    public ResponseEntity<List<TeacherDTO>> getTeachers() {
        return ok(teachersService.getAllTeachers());
    }

    @RequestMapping("/teacher")
    public ResponseEntity<List<TeacherDTO>> getTeachersPage(@RequestParam(name = "pagenum", required = true) String pagenum,
                                                            @RequestParam(name = "pagesize", required = true) String pagesize,
                                                            @RequestParam(name = "sort", required = true) String sort,
                                                            @RequestParam(name = "group", required = true) String group) {

        return ok(teachersService.getTeachersPage(pagenum, pagesize, sort, group));
    }
}
