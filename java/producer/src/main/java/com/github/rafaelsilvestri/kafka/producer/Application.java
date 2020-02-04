package com.github.rafaelsilvestri.kafka.producer;

import com.github.rafaelsilvestri.kafka.producer.config.ApplicationConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;
import reactor.netty.DisposableServer;
import reactor.netty.http.server.HttpServer;

public class Application {

    private final static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        log.info("[Starting application]");

        try (AnnotationConfigApplicationContext ctx
                     = new AnnotationConfigApplicationContext(ApplicationConfig.class)) {

//            KafkaEventPublisher producer = ctx.getBean(KafkaEventPublisher.class);
//            producer.send("message " + LocalTime.now());

            // bootstrap netty http server
            HttpHandler handler = WebHttpHandlerBuilder.applicationContext(ctx).build();
            ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
            HttpServer server = HttpServer.create().host("localhost").port(8080);
            DisposableServer disposableServer = server.handle(adapter).bind().block();
            disposableServer.onDispose().block();

        } finally {
            log.info("[Application finished]");
        }
    }
}
