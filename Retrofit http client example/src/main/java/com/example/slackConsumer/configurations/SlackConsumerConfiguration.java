package com.example.slackConsumer.configurations;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class SlackConsumerConfiguration {

  @Value(value = "${slack.baseUrl}")
  String baseUrl;

  @Value(value = "${slack.token}")
  String token;

  @Bean
  public HttpLoggingInterceptor loggingInterceptor() {
    HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
    logging.setLevel(Level.BODY);

    return logging;
  }

  @Bean
  public OkHttpClient slackCall() {
    return new OkHttpClient().newBuilder()
        .addInterceptor(loggingInterceptor())
        .build();
  }

  @Bean
  public Retrofit retrofit() {
    return new Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(slackCall())
        .build();
  }
}