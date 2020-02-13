package com.github.rafaelsilvestri.kafka.producer.person;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * A functional style of a "Person handler"
 *
 * @author Rafael Silvestri
 */
@Component
public class PersonHandler {

    private static final Logger log = LoggerFactory.getLogger(PersonHandler.class);

    private PersonService personService;

    public PersonHandler(PersonService personService) {
        this.personService = personService;
    }

    Mono<ServerResponse> post(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(Person.class)
                .map(personService::save)
                .flatMap(p -> ServerResponse.ok().body(Mono.just(p), Person.class))
                .doOnError(ex -> log.error("Oops, something went wrong!!!", ex))
                .doOnSuccess(e -> log.info("Success!!! {}", e.statusCode()));
    }
}
