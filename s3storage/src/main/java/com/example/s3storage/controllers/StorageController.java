package com.example.s3storage.controllers;


import static java.lang.String.format;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

import com.example.s3storage.domain.dto.FileDto;
import com.example.s3storage.service.S3Storage;
import java.nio.charset.StandardCharsets;
import javax.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class StorageController {

    private final S3Storage s3Storage;

    @PostMapping
    public ResponseEntity<?> uploadFile(@RequestBody FileDto newfile) {

//        System.out.println(new String(newfile.getFile(), StandardCharsets.UTF_8));
        return ok(s3Storage.uploadFile(newfile));
    }

    @GetMapping("/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable(value = "filename") @NotBlank(message = "Filename cannot be empty!") String filename) {
        return ok(s3Storage.downloadFile(filename));
    }

    @DeleteMapping("/{filename}")
    public ResponseEntity<?> deleteFile(@PathVariable(value = "filename") @NotBlank(message = "Filename cannot be empty!") String filename) {
        return ok(s3Storage.deleteFile(filename));
    }


}
