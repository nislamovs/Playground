package com.example.jdbcexample.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@SuperBuilder(toBuilder = true, builderMethodName = "superBuilder", buildMethodName = "superBuild")
public class TeacherDTO extends PersonDTO {

    private Long class_id;
    private Long subject_id;
    private Boolean is_head;
}
