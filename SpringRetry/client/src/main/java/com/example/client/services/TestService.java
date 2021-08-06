package com.example.client.services;


import static com.example.client.configurations.HttpClientConfiguration.BASE_URL;
import static java.time.LocalTime.now;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {

  private final OkHttpClient client;

  @SneakyThrows
  public String testCall1() {

    Request testRequest = new Builder()
        .addHeader("Content-type", "application/json")
        .url(BASE_URL+"test1").build();

    Request req = testRequest.newBuilder().get().build();
    Response resp = client.newCall(req).execute();

    return new String(Objects.requireNonNull(resp.body()).bytes(), StandardCharsets.UTF_8);
  }

  @SneakyThrows
  @Retryable(value = Exception.class, maxAttempts = 5, backoff = @Backoff(delay = 1500))
  public String testCall2() {

    Request testRequest = new Builder()
        .addHeader("Content-type", "application/json")
        .url(BASE_URL+"test2").build();

    Request req = testRequest.newBuilder().get().build();
    Response resp = client.newCall(req).execute();

    return new String(Objects.requireNonNull(resp.body()).bytes(), StandardCharsets.UTF_8);
  }

  @Recover
  public String recover(Exception e, String sql) {

    return "Epic fail! timestamp: " + now();
  }

}
