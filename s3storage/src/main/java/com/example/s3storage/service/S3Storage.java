package com.example.s3storage.service;


import static java.lang.String.format;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.s3storage.domain.dto.FileDto;
import com.example.s3storage.domain.exceptions.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class S3Storage {

  @Value("${application.bucket.name}")
  private String bucketName;

  private final AmazonS3 s3Client;

  @SneakyThrows
  public String uploadFile(FileDto file) {
    String filename = System.currentTimeMillis() + "_" + file.getFilename();
    @Cleanup("delete") File fileObj = new File(filename);
    FileUtils.writeByteArrayToFile(fileObj, file.getFile());

    s3Client.putObject(new PutObjectRequest(bucketName, filename, fileObj));

    return format("File [%s] uploaded successfully.", filename);
  }

  @SneakyThrows
  public FileDto downloadFile(String filename) {

    S3Object s3Object;

    try {
      s3Object = s3Client.getObject(bucketName, filename);
    } catch (AmazonS3Exception e) {
      throw new FileNotFoundException(filename, e);
    }

    S3ObjectInputStream inputStream = s3Object.getObjectContent();

//    System.out.println(new String(IOUtils.toByteArray(inputStream), StandardCharsets.UTF_8));

    return FileDto.builder()
        .file(IOUtils.toByteArray(inputStream))
        .filename(filename)
        .build();
  }

  public String deleteFile(String filename) {

    s3Client.deleteObject(bucketName, filename);
    return format("File [%s] removed successfully.", filename);
  }
}
