package com.example.archives;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequiredArgsConstructor
public class Controller {

    private final AchivationService archiveService;

    @GetMapping("/compress/")
    public ResponseEntity<?> compress() {

        return ResponseEntity.ok("");
    }

    @GetMapping("/decompress/")
    public ResponseEntity<?> decompress() {

        return ResponseEntity.ok("");
    }

    @GetMapping("/recompress/")
    public ResponseEntity<?> recompress() {

        return ResponseEntity.ok("");
    }
}
