package com.example.springjdbc.controller;

import com.example.springjdbc.domain.AbstractDTO;
import com.example.springjdbc.domain.TeacherDTO;
import com.example.springjdbc.service.TeachersService;
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

    @GetMapping("/teacher/all")
    public List<TeacherDTO> getTeachers() {
        return teachersService.getAllTeachers();
    }

    @GetMapping("/teacher")
    public List<TeacherDTO> getTeachersPage(@RequestParam(name = "pagenum", required = true) String pagenum,
                                            @RequestParam(name = "pagesize", required = true) String pagesize,
                                            @RequestParam(name = "sort", required = true) String sort,
                                            @RequestParam(name = "group", required = true) String group) {

        return teachersService.getTeachersPage(pagenum, pagesize, sort, group);
    }

    @GetMapping("/teacher/{id}")
    public TeacherDTO getTeacherById(@PathVariable("id") String id) {
        return teachersService.getTeacherById(id);
    }

    @GetMapping("/teacher/findbyemail")
    public TeacherDTO getTeacherByEmail(@RequestParam(name = "email", required = true) String email) {
        return teachersService.getTeacherByEmail(email);
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
