package com.github.rafaelsilvestri.kafka;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        KafkaEventPublisher producer = ctx.getBean(KafkaEventPublisher.class);
        producer.send("message 2");


    }
}
