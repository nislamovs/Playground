package com.orika.orikaexample.domain.test4;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dest4 {
    private String firstname;
    private String email;
    private int years;
    private MyDate date1;
}
