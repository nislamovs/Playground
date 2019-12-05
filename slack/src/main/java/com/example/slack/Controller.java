package com.example.slack;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final SlackService slackService;

    @GetMapping("/")
    public ResponseEntity<?> pushMessage() {

        slackService.pushMessage("{\"text\":\"Helloc23424234gfgfdg444444fdgfvxcv, World!\"}");
        return ResponseEntity.ok("");
    }
}
