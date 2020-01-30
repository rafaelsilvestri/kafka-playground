package com.github.rafaelsilvestri.kafka;


import com.github.rafaelsilvestri.kafka.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("[Starting application]");

        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        KafkaEventPublisher producer = ctx.getBean(KafkaEventPublisher.class);
        producer.send("message 2");

        log.error("[ERROR TEST]");
        log.info("[Application finishes]");
    }
}
