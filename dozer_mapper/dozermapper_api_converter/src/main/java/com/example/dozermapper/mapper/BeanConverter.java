package com.example.dozermapper.mapper;

import com.example.dozermapper.beans.Citizen;
import com.example.dozermapper.beans.Developer;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
public class BeanConverter {

    @Bean
    DozerBeanMapper mapper() {

        BeanMappingBuilder builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Developer.class, Citizen.class)
                        .fields("name", "firstname")
                        .fields("surname", "lastname")
                        .fields("age", "age")
                        .fields("speciality", "profession")
                        .fields("experience", "experience")
                        .fields("salary", "salary");
            }
        };

       DozerBeanMapper mapper = new DozerBeanMapper();
       mapper.addMapping(builder);

       return mapper;
    }
}
