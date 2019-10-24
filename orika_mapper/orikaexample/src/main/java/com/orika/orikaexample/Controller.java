package com.orika.orikaexample;

import com.orika.orikaexample.domain.test.Dest;
import com.orika.orikaexample.domain.test.Source;
import com.orika.orikaexample.domain.test2.Dest2;
import com.orika.orikaexample.domain.test2.Source2;
import com.orika.orikaexample.domain.test3.Dest3;
import com.orika.orikaexample.domain.test3.Source3;
import com.orika.orikaexample.domain.test4.Dest4;
import com.orika.orikaexample.domain.test4.Source4;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    MapperFacade mapper;

    //Forward conversion
    @GetMapping("test")
    public ResponseEntity<?> test() {
		Source src = Source.builder().age(1022).name("vasja    test ").build();
		Dest dest = mapper.map(src, Dest.class);
        return ok(dest);
    }

    //Backward conversion
    @GetMapping("test1")
    public ResponseEntity<?> test1() {
        Dest2 dest2 = Dest2.builder().age(1022).name("vasja").email("asdas@asdasd.ff     test1").build();
        Source2 src2 = mapper.map(dest2, Source2.class);
        return ok(src2);
    }

    //Reduced field count conversion
    @GetMapping("test2")
    public ResponseEntity<?> test2() {
        Source2 src = Source2.builder().age(1022).name("vasja").email("asdas@asdasd.ff   test2").build();
        Dest dest = mapper.map(src, Dest.class);
        return ok(dest);
    }

    //Different field names conversion
    @GetMapping("test3")
    public ResponseEntity<?> test3() {
        Source3 src3 = Source3.builder().age(1022).name("vasja").email("asdas@asdasd.ff   test3").build();
        Dest3 dest3 = mapper.map(src3, Dest3.class);
        return ok(dest3);
    }

    //Different data types conversion
    @GetMapping("test4")
    public ResponseEntity<?> test4() {
        Source4 src4 = Source4.builder().age(1022).name("vasja").email("asdas@asdasd.ff   test4").date1(new Date()).build();
        Dest4 dest4 = mapper.map(src4, Dest4.class);
        System.out.println(dest4);
        return ok(dest4);
    }

}
