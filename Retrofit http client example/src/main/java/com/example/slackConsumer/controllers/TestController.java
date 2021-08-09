package com.example.slackConsumer.controllers;

import com.example.slackConsumer.services.SlackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final SlackService retrofitService;

    @GetMapping("/")
    public ResponseEntity<?> pushMessage() {
        return ResponseEntity.ok(retrofitService.test());
    }
}
