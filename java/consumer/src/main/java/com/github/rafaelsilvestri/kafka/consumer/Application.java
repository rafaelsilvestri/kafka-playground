package com.github.rafaelsilvestri.kafka.consumer;

import com.github.rafaelsilvestri.kafka.consumer.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("\n\n===== STARTING CONSUMER =====\n");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        log.info("\n\n===== CONSUMER STARTED =====");
    }
}
