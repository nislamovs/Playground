package com.orika.orikaexample;

import com.orika.orikaexample.domain.test.Dest;
import com.orika.orikaexample.domain.test.Source;
import com.orika.orikaexample.domain.test2.Dest2;
import com.orika.orikaexample.domain.test2.Source2;
import com.orika.orikaexample.domain.test3.Dest3;
import com.orika.orikaexample.domain.test3.Source3;
import com.orika.orikaexample.domain.test4.Dest4;
import com.orika.orikaexample.domain.test4.MyConverter;
import com.orika.orikaexample.domain.test4.Source4;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.ConverterFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MyConfiguration extends ConfigurableMapper {

    @Override
    protected void configure(MapperFactory factory) {

        ConverterFactory converterFactory = factory.getConverterFactory();
        converterFactory.registerConverter(new MyConverter());

        factory.classMap(Source.class, Dest.class).byDefault().register();
        factory.classMap(Source2.class, Dest2.class).byDefault().register();
        factory.classMap(Source2.class, Dest.class).byDefault().register();

        factory.classMap(Source3.class, Dest3.class)
                .field("name", "firstname")
                .field("age", "years")
                .register();

        factory.classMap(Source4.class, Dest4.class)
                .field("name", "firstname")
                .field("age", "years")
                .byDefault()
                .register();

//        Source2 src = Source2.builder().age(1022).name("vasja").email("asdas@asdasd.ff   test2").build();
//        Dest dest = mapper.map(src, Dest.class);

        //Mapping of generics
//        Type<MyGenericClass<GenericParam1, GenericParam2>> type = new TypeBuilder<MyGenericClass<GenericParam1, GenericParam2>>() {}.build();

    }
}
