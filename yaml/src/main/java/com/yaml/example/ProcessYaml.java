package com.yaml.example;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@PropertySource(factory = YamlPropertySourceFactory.class, value = "file:./src/main/java/com/yaml/example/bookdata.yml")
@ConfigurationProperties
@Configuration
public class ProcessYaml {

    private static  List<BookData> books = new ArrayList<>();;

    public void setBooks(List<BookData> books) {
        ProcessYaml.books = books;
    }

    public List<BookData> getBooks() {
        return books;
    }

    public static void presetBookDataCollection() {
        System.out.println(">>>>>>>>>>>>.    "+ books);

    }
}
