package com.example.slack;

import okhttp3.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class AppConfiguration {

    @Value(value = "${slack.url}")
    String token;

    @Bean
    public Request slackRequest() {
        return new Request.Builder()
                .addHeader("Content-type", "application/json")
                .url(token).build();
    }

    @Bean
    public OkHttpClient slackCall() {
        return new OkHttpClient();
    }
}
