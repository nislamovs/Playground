package com.orika.orikaexample.domain.test4;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import java.util.Date;

public class MyConverter extends CustomConverter<Date, MyDate> {

    @Override
    public MyDate convert(Date source, Type<? extends MyDate> destinationType) {
        return MyDate.builder().date(source.getDate()).month(source.getMonth()).build();
    }
}
