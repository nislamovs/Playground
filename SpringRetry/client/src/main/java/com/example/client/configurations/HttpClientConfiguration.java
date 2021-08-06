package com.example.client.configurations;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfiguration {

  public static final String BASE_URL= "http://localhost:8082/api/v1/";

  @Bean
  public Request clientRequest() {
    return new Request.Builder()
        .addHeader("Content-type", "application/json")
        .url(BASE_URL).build();
  }

  @Bean
  public OkHttpClient client() {
    return new OkHttpClient.Builder()
        .addInterceptor(new SimpleLoggingInterceptor())
        .build();
  }
}
