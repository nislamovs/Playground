package com.example.jdbcexample.controllers;


import com.example.jdbcexample.services.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class PersonController {

    private final PersonService personService;

    @GetMapping("/person")
    public ResponseEntity<?> findPerson(@RequestParam(value = "email", required = true) String email) {
        return ok(personService.findPersonByEmail(email));
    }
}
