package com.example.client.controllers;


import com.example.client.services.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TestController {

  private final TestService testService;

  @GetMapping("/test1")
  public ResponseEntity test1() {
    return ResponseEntity.ok(testService.testCall1());
  }

  @GetMapping("/test2")
  public ResponseEntity test2() {
    return ResponseEntity.ok(testService.testCall2());
  }

}
