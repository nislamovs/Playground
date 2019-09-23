package com.example.dozermapper.mapper;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class BeanConverter {

    @Value("${beanConverterPath}")
    String mappingFile;

    @Bean
    DozerBeanMapper mapper() {
       DozerBeanMapper mapper = new DozerBeanMapper();
       mapper.setMappingFiles(Arrays.asList(mappingFile));

       return mapper;
    }
}
