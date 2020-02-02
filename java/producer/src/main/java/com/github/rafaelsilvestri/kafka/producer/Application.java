package com.github.rafaelsilvestri.kafka.producer;


import com.github.rafaelsilvestri.kafka.producer.config.ApplicationConfig;
import com.github.rafaelsilvestri.kafka.producer.service.KafkaEventPublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalTime;

public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("[Starting application]");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        KafkaEventPublisher producer = ctx.getBean(KafkaEventPublisher.class);
        producer.send("message " + LocalTime.now());

        log.info("[Application finishes]");
    }
}
