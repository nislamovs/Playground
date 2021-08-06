package com.example.client.configurations;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfiguration {

  static final String BASE_URL = "http://localhost:8082/api/v1/";


  @Bean
  public Gson gsonFactory() {
    return new GsonBuilder()
        .setLenient()
        .create();
  }

  @Bean
  public Retrofit retrofit() {
    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gsonFactory()))
        .build();
  }

}

