package com.example.jdbcexample.controllers;

import com.example.jdbcexample.dto.PupilDTO;
import com.example.jdbcexample.dto.SubjectDTO;
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
public class SubjectController {

    private final SubjectsService subjectsService;

    @RequestMapping("/subject/all")
    public ResponseEntity<List<SubjectDTO>> getSubjects() {
        return ok(subjectsService.getAllSubjects());
    }

    @RequestMapping("/subject")
    public ResponseEntity<List<SubjectDTO>> getSubjectsPage(@RequestParam(name = "pagenum", required = true) String pagenum,
                                                        @RequestParam(name = "pagesize", required = true) String pagesize,
                                                        @RequestParam(name = "sort", required = true) String sort,
                                                        @RequestParam(name = "group", required = true) String group) {

        return ok(subjectsService.getSubjectsPage(pagenum, pagesize, sort, group));
    }

}
