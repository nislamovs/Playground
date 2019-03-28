package com.example.aspects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {



    @GetMapping("/")
    public ResponseEntity<?> runTest() {

        Developer dev = new Developer("John doe", "brainfuck instructor", "80 lvl");
        System.out.println("Object DEV created.");
        System.out.println(dev);
//        dev.throwSomeMysticException();

        return new ResponseEntity<>(HttpStatus.OK);
    }


}
