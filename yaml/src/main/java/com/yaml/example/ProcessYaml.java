package com.yaml.example;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@PropertySource(factory = YamlPropertySourceFactory.class, value = "file:./src/main/java/com/yaml/example/bookdata.yml")
@ConfigurationProperties
@Configuration
public class ProcessYaml {
    private static  List<BookData> books = new ArrayList<>();

    public void setBooks(List<BookData> books) {
        ProcessYaml.books = books;
    }

    public static void presetBookDataCollection() {
//        System.out.println(">>>>>>>>>>>>.    "+ books);

//        books.forEach(book -> System.out.println(book.getIsFailed()));
        books.forEach(book -> System.out.println(book.getAdditionalData()));
//        books.forEach(System.out::println);

    }
}
