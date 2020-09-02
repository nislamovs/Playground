package com.example.twodatasources.controller;

import com.example.twodatasources.domain.AbstractDTO;
import com.example.twodatasources.domain.TeacherDTO;
import com.example.twodatasources.services.TeachersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class Teachers {

    private final TeachersService teachersService;

    @GetMapping("/test")
    public String test() {
        return "Test OK!";
    }

    @GetMapping("/teacher/all")
    public List<TeacherDTO> getTeachers() {
        return teachersService.getAllTeachers();
    }

    @GetMapping("/teacher/{id}")
    public TeacherDTO getTeacherById(@PathVariable("id") String id) {
        return teachersService.getTeacherById(id);
    }

    @PostMapping("/teacher")
    public AbstractDTO newTeacher(@Valid @RequestBody TeacherDTO newTeacher) {
        return teachersService.addNewTeacher(newTeacher);
    }

    @PutMapping("/teacher")
    public AbstractDTO editTeacher(@Valid @RequestBody TeacherDTO teacher) {
        return teachersService.editTeacherData(teacher);
    }

    @DeleteMapping("/teacher/{id}")
    public AbstractDTO deleteTeacher(@PathVariable("id") String id) {
        return teachersService.deleteTeacher(id);
    }

}
