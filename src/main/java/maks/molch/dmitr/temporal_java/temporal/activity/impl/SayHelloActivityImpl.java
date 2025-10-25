package maks.molch.dmitr.temporal_java.temporal.activity.impl;

import lombok.extern.slf4j.Slf4j;
import maks.molch.dmitr.temporal_java.temporal.activity.SayHelloActivity;

@Slf4j
public class SayHelloActivityImpl implements SayHelloActivity {
    @Override
    public String sayHello(String name) {
        log.info("Hello, {}!", name);
        return "Hello, %s!".formatted(name);
    }
}
