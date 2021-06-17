package com.example.stats.controller;


import com.example.stats.services.ConfigService;
import io.micrometer.core.annotation.Counted;
import io.micrometer.core.annotation.Timed;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Math.abs;
import static org.springframework.http.ResponseEntity.ok;

@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
@Slf4j
@RestController

public class Controller {

    private final ConfigService configService;

    @GetMapping("/test1")
//    @Timed(value = "greeting.time", description = "Time taken to return greeting")
//    @Timed
//    @Timed(description = "this.is.my.metric", value = "my.metric", extraTags = {"my.metric.name1", "my.metric.name1", "my.metric.name1","my.metric.name1", "my.metric.name1", "my.metric.name1"})
//    @Timed(description = "this.is.my.metricc456456456", value = "my.metricc")
//    @Counted("hello-world")
    public ResponseEntity<String> testFunctionality() {
        System.out.println("--- Testing functionality #1... ---");
        log.trace("--- Testing functionality #1... ---");
        configService.launch();
        return ok("test #1 ok!");
    }

    @GetMapping("/test2")
    public ResponseEntity<String> testFunctionality2() {
        System.out.println("--- Testing functionality #2... ---");
        log.trace("--- Testing functionality #2... ---");
        configService.launch2();
        return ok("test #2 ok!");
    }

    @GetMapping("/test3")
    public ResponseEntity<String> testFunctionality3() {
        System.out.println("--- Testing functionality #3... ---");
        log.trace("--- Testing functionality #3... ---");
        configService.checkNumber(abs(new Random().nextInt()));
        return ok("test #3 ok!");
    }
}
