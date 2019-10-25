package com.orika.orikaexample.domain.test5;

import com.orika.orikaexample.MyConfiguration;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;

@RequiredArgsConstructor
public class Converter {

    private static final MapperFacade mapper = new MyConfiguration();

    public static Dest5 toResponse(Source5 s) {
        return mapper.map(s, Dest5.class);
    }

    public static Dest51 from(Source5 s) {
        return mapper.map(s, Dest51.class);
    }
}
