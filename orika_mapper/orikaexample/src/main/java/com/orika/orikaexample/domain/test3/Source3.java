package com.orika.orikaexample.domain.test3;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Source3 {
    private String name;
    private String email;
    private int age;

}
