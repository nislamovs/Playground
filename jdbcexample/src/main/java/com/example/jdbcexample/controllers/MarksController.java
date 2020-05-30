package com.example.jdbcexample.controllers;

import com.example.jdbcexample.dao.SubjectMarkDAO;
import com.example.jdbcexample.dto.PupilDTO;
import com.example.jdbcexample.dto.SubjectMarkDTO;
import com.example.jdbcexample.services.MarksService;
import com.example.jdbcexample.services.PupilsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.lang.Long.parseLong;
import static org.springframework.http.ResponseEntity.ok;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class MarksController {

    private final MarksService marksService;

    @GetMapping("/mark/all")
    public ResponseEntity<?> getMarks() {
        return ok(marksService.getAllMarks());
    }

    @GetMapping(path = "/mark", params = { "pupilId" })
    public ResponseEntity<?> getMarks(@RequestParam(value="pupilId") String pupilId) {
        return ok(marksService.getMarksByPupilId(pupilId));
    }

    @GetMapping("/mark")
    public ResponseEntity<?> getMarksPage(@RequestParam(name = "pagenum", required = true) String pagenum,
                                          @RequestParam(name = "pagesize", required = true) String pagesize,
                                          @RequestParam(name = "sort", required = true) String sort,
                                          @RequestParam(name = "group", required = true) String group) {

        return ok(marksService.getMarksPage(pagenum, pagesize, sort, group));
    }

    @GetMapping("/mark")
    public ResponseEntity<?> getMarksByDate(@RequestParam(name = "startDate", required = true) String startDate,
                                            @RequestParam(name = "endDate", required = true) String endDate) {

        return ok(marksService.getMarksByDate(startDate, endDate));
    }

    @PostMapping("/mark")
    public ResponseEntity<?> addMark(@RequestBody SubjectMarkDAO mark) {
        return ok(marksService.addNewMark(mark));
    }

    @PutMapping("/mark/{id}")
    public ResponseEntity<?> editMark(@RequestBody SubjectMarkDAO mark, @PathVariable String id) {
        mark.setId(parseLong(id));
        return ok(marksService.editMark(mark));
    }

    @DeleteMapping("/mark/{id}")
    public ResponseEntity<?> removeMark(@RequestBody SubjectMarkDAO mark, @PathVariable String id) {
        return ok(marksService.deleteMark(id));
    }
}