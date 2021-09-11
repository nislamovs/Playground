package com.example.feign.clients;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients("com.example.feign.clients")
public class FeignConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

//    @Bean
//    public RequestInterceptor requestInterceptor(FeignRetryProperties feignRetryProperties) {
//        return requestTemplate -> requestTemplate.header("x-api-key", feignRetryProperties.getApiKey());
//    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(100,5000,5);
    }
}