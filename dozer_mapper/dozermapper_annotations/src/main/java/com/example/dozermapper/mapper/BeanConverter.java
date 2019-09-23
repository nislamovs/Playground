package com.example.dozermapper.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class BeanConverter {

    @Bean
    DozerBeanMapper mapper() {
       DozerBeanMapper mapper = new DozerBeanMapper();
       return mapper;
    }
}
