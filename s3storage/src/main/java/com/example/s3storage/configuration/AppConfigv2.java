package com.example.s3storage.configuration;


import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@Configuration
@Profile("SoftwareAWSSDK")
public class AppConfigv2 {

  @Value("${cloud.aws.credentials.access-key}")
  private String accessKey;

  @Value("${cloud.aws.credentials.secret-key}")
  private String accessSecret;

  @Value("${cloud.aws.region.static:eu-central-1}")
  private String regionVal;

  @Bean
  public S3Client s3Client() {
    AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, accessSecret);

      return S3Client.builder()
          .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
          .region(Region.of(regionVal))
          .build();
  }

}
