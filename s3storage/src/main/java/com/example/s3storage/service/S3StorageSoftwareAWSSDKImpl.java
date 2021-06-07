package com.example.s3storage.service;


import static java.lang.String.format;
import static software.amazon.awssdk.core.sync.ResponseTransformer.toBytes;

import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.s3storage.domain.dto.FileDto;
import com.example.s3storage.domain.exceptions.FileNotFoundException;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import software.amazon.awssdk.core.ResponseBytes;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.S3Object;

@Slf4j
@Service
@RequiredArgsConstructor
@Profile("SoftwareAWSSDK")
public class S3StorageSoftwareAWSSDKImpl implements S3Storage {

  @Value("${application.bucket.name}")
  private String bucketName;

  private final S3Client s3Client;

  @PostConstruct
  private void postConstruct() {
    System.out.println("S3StorageSoftwareAWSSDKImpl [v2] bean loaded.");
  }

  public String uploadFile(FileDto file) {
    String filename = System.currentTimeMillis() + "_" + file.getFilename();

    PutObjectRequest request = PutObjectRequest.builder()
        .bucket(bucketName)
        .key(filename)
        .build();

    s3Client.putObject(request, RequestBody.fromBytes(file.getFile()));

    return format("File [%s] uploaded successfully.", filename);
  }

  public FileDto downloadFile(String filename) {

    GetObjectRequest request = GetObjectRequest.builder()
        .bucket(bucketName)
        .key(filename)
        .build();

    ResponseBytes<GetObjectResponse> profile;

    try {
      profile = s3Client.getObject(request, toBytes());
    } catch (S3Exception e) {
      throw new FileNotFoundException(filename, e);
    }

    return FileDto.builder()
        .file(profile.asByteArray())
        .filename(filename)
        .build();
  }

  public String deleteFile(String filename) {

    DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
        .bucket(bucketName)
        .key(filename)
        .build();

    s3Client.deleteObject(deleteObjectRequest);

    return format("File [%s] removed successfully.", filename);
  }
}
