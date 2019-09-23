package com.example.dozermapper.controllers;

import com.example.dozermapper.beans.Citizen;
import com.example.dozermapper.beans.Developer;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    @Autowired
    DozerBeanMapper mapper;

    @GetMapping("/")
    public ResponseEntity runTest() {

        Developer developer = new Developer("John", "Doe", "50", "brainfuck instructor","10", "5000");
        System.out.println("Object DEV created.");
        System.out.println(developer);

        Citizen citizen = mapper.map(developer, Citizen.class);


        return ResponseEntity.ok(citizen);
    }


}
