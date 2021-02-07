package com.exectime.measurement.controllers;


import com.exectime.measurement.util.LogExecutionTime;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class TestController {

    @GetMapping("/test")
    @LogExecutionTime(value = "TESTING_ENDPOINT_EXECUTION_TIME")
    public String testExecTime() {
        return smthHappeningHere("asdasdasd");
    }

    public String smthHappeningHere(String msg) {
        sss();
        return msg + " test ok!";
    }

    public void  sss() {
        System.out.println("asdasdasd");
        System.out.println("asdasdasd");
        System.out.println("asdasdasd");
    }
}
