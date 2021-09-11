package com.example.feign.controller;


import static java.time.LocalTime.now;

import com.example.feign.clients.SlackClient;
import com.example.feign.domain.dto.SlackPayload;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TestController {

    private final SlackClient slackClient;

//    @PostMapping("/testslack")
    @GetMapping("/testslack")
    public ResponseEntity<?> pushMessage() {

      slackClient.pushSlackMsg(SlackPayload.builder().text(placeTimestamp() + "Last mesg -> ").build());
      return ResponseEntity.ok("Message sent!");
    }

    private String placeTimestamp() {
      return "Timestamp : [" + now() + "] ";
    }
}
