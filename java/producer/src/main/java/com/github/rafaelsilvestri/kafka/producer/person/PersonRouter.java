package com.github.rafaelsilvestri.kafka.producer.person;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Person router config (functional style). The supported versions could be handled by this class
 *
 * @author Rafael Silvestri
 */
@Component
public class PersonRouter {

    /**
     * Routes to version 2
     */
    @Bean
    public RouterFunction<ServerResponse> personV2Route(PersonHandler handler) {
        // look at nested, path (for context, version, accept, produces, etc)
        return nest(accept(APPLICATION_JSON),
                route(POST("/person"), handler::post));
    }
}
