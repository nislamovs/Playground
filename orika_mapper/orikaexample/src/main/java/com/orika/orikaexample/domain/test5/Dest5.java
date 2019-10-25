package com.orika.orikaexample.domain.test5;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Dest5 {
    private String firstname;
    private String email;
    private int years;
}
