package com.example.telegram.controllers;

import static java.time.LocalTime.now;
import static org.springframework.http.ResponseEntity.ok;

import com.example.telegram.services.TelegramBotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
@RequiredArgsConstructor
public class TestController {

  private final TelegramBotService botService;

  @GetMapping("/test")
  public ResponseEntity test() {

    botService.sendMessage("test msg - timestamp : " + now());
    return ok().build();
  }

}
