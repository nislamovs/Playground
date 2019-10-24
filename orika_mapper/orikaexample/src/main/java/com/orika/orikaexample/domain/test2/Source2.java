package com.orika.orikaexample.domain.test2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Source2 {
    private String name;
    private String email;
    private int age;

}
