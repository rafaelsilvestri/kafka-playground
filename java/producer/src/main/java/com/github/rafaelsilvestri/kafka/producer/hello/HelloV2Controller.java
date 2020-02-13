package com.github.rafaelsilvestri.kafka.producer.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloV2Controller {

    @GetMapping("v2/hello")
    public String hello() {
        // this is a non-reactive controller
        return "Hello from Annotated Controller";
    }
}
