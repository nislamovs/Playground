package com.booklibrary.app.configuration;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

}
