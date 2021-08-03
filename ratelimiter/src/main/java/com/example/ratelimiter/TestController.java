package com.example.ratelimiter;


import static org.springframework.http.ResponseEntity.ok;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class TestController {

  @GetMapping("/test1")
  @RateLimiter(name = "service1", fallbackMethod = "fallbackZZ")
  public ResponseEntity test() {
    System.out.println("In testRateLimiter");
    return ok("Test ok!");
  }

  private ResponseEntity fallbackZZ(Throwable t) {
    System.out.println("in fallback");
    return new ResponseEntity("Too much requests!", HttpStatus.SERVICE_UNAVAILABLE);
  }

}
