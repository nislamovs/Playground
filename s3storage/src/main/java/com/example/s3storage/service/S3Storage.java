package com.example.s3storage.service;

import com.example.s3storage.domain.dto.FileDto;

public interface S3Storage {

  String uploadFile(FileDto file);

  FileDto downloadFile(String filename);

  String deleteFile(String filename);
}
