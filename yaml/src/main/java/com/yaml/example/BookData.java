package com.yaml.example;

import lombok.*;
import org.javamoney.moneta.Money;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Data
@Component
public class BookData {

    private String bookId;

    private String bookTitle;

    private String isbn;

    private String author;

    private List<Subject> subjects;

    private String description;

    private String annotation;

    private int copyrightYear;

    private Language language;

    private int totalCount;

    private int availableCount;

    private BigDecimal popularityRate;

    private Money internalPrice;

    public static enum Subject { MANAGEMENT, SOFTWARE_DEVELOPMENT, PSYCHOLOGY, SCIENCE, ENGINEERING, MEDICINE, PHARMACOLOGY, KIDS, SPORT }

    public static enum Language { EN, LV, RU, DE, FR }

}
