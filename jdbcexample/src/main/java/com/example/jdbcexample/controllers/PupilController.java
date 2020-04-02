package com.example.jdbcexample.controllers;

import com.example.jdbcexample.dao.PupilDAO;
import com.example.jdbcexample.dto.PupilDTO;
import com.example.jdbcexample.services.PupilsService;
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
public class PupilController {

    private final PupilsService pupilsService;

    @RequestMapping("/pupil/all")
    public ResponseEntity<List<PupilDTO>> getPupils() {
        return ok(pupilsService.getAllPupils());
    }

    @RequestMapping("/pupil")
    public ResponseEntity<List<PupilDTO>> getPupilsPage(@RequestParam(name = "pagenum", required = true) String pagenum,
                                                        @RequestParam(name = "pagesize", required = true) String pagesize,
                                                        @RequestParam(name = "sort", required = true) String sort,
                                                        @RequestParam(name = "group", required = true) String group) {

        return ok(pupilsService.getPupilsPage(pagenum, pagesize, sort, group));
    }
}
