package com.example.jdbcexample.controllers;

import com.example.jdbcexample.dto.SchoolClassDTO;
import com.example.jdbcexample.dto.SubjectDTO;
import com.example.jdbcexample.services.ClassesService;
import com.example.jdbcexample.services.SubjectsService;
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
public class SchoolClassController {

    private final ClassesService classesService;

    @RequestMapping("/class/all")
    public ResponseEntity<List<SchoolClassDTO>> getClasses() {
        return ok(classesService.getAllClasses());
    }

    @RequestMapping("/class")
    public ResponseEntity<List<SchoolClassDTO>> getSubjectsPage(@RequestParam(name = "pagenum", required = true) String pagenum,
                                                                    @RequestParam(name = "pagesize", required = true) String pagesize,
                                                                    @RequestParam(name = "sort", required = true) String sort,
                                                                    @RequestParam(name = "group", required = true) String group) {

        return ok(classesService.getClassesPage(pagenum, pagesize, sort, group));
    }
}
