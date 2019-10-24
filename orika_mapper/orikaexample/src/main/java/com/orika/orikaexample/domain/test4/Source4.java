package com.orika.orikaexample.domain.test4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Source4 {
    private String name;
    private String email;
    private int age;
    private Date date1;

}
