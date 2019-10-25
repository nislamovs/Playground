package com.orika.orikaexample;

import com.orika.orikaexample.domain.test.Dest;
import com.orika.orikaexample.domain.test.Source;
import com.orika.orikaexample.domain.test2.Dest2;
import com.orika.orikaexample.domain.test2.Source2;
import com.orika.orikaexample.domain.test3.Dest3;
import com.orika.orikaexample.domain.test3.Source3;
import com.orika.orikaexample.domain.test4.Dest4;
import com.orika.orikaexample.domain.test4.Source4;
import com.orika.orikaexample.domain.test5.Dest5;
import com.orika.orikaexample.domain.test5.Source5;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.orika.orikaexample.domain.test5.Converter.from;
import static com.orika.orikaexample.domain.test5.Converter.toResponse;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/v2/")
public class Controller2 {

    @Autowired
    MapperFacade mapper;

    //Different data types conversion [object to object]
    @GetMapping("test5")
    public ResponseEntity<?> test5() {
        Source5 src5 = Source5.builder().age(1022).name("vasja").email("asdas@asdasd.ff   test5").build();
        Dest5 dest5 = new Dest5();
        mapper.map(src5, dest5);
        System.out.println(dest5);
        return ok(dest5);
    }

    @GetMapping("test6")
    public ResponseEntity<?> test6() {
        Source5 src5 = Source5.builder().age(1022).name("vasja").email("asdas@asdasd.ff   test5").build();
        System.out.println(toResponse(src5));
        System.out.println(from(src5));
        return ok(toResponse(src5));
    }

}
