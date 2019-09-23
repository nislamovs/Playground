package com.example.dozermapper.mapper;

import com.example.dozermapper.beans.Citizen;
import com.example.dozermapper.beans.Developer;
import org.dozer.CustomConverter;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import static java.time.Year.now;

public class DozerCustomConverter implements CustomConverter {
    @Override
    public Object convert(Object dest, Object source, Class<?> arg2, Class<?> arg3) {
        if (source == null)
            return null;

        if (source instanceof Developer) {
            Developer developer = (Developer) source;
            int birthYear = Integer.valueOf(developer.getBirthYear());
            int age = LocalDate.now().getYear() - birthYear;
            return new Citizen(developer.getName(), developer.getSurname(), age, developer.getSpeciality(), Integer.valueOf(developer.getExperience()), new BigDecimal(developer.getSalary()));

        } else if (source instanceof Citizen) {
            Citizen citizen = (Citizen) source;
            String birthYear = String.valueOf(LocalDate.now().getYear() - citizen.getAge());
            return new Developer(citizen.getFirstname(), citizen.getLastname(), birthYear, citizen.getProfession(), String.valueOf(citizen.getExperience()), String.valueOf(citizen.getSalary()));
        }

        return null;
    }
}