package com.damian.sr;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
@Log4j2
public class Test {
    public static Flux<String> getIterable(){
        var fruits = new ArrayList<String>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grapes");
        return Flux.fromIterable(fruits);
    }
    public static Flux<String> mapFunction(){
        log.info("Usage of map() function.");
        var fruits = getIterable();
        return fruits.map(String::toUpperCase);
    }
    public static Flux<String> flatMapFunction(){
        log.info("Usage of flatMap() function.");
        var fruits = getIterable();
        return fruits.flatMap(s->Mono.just(s.toLowerCase()));
    }
    public static Flux<String> skipFunction(){
        log.info("Usage of skip() function.");
        var fruits = getIterable();
        return fruits.skip(2);
    }
    public static void main(String[] args) {
        mapFunction().subscribe(log::info);
        flatMapFunction().subscribe(log::info);
        skipFunction().subscribe(log::info);

    }
}
