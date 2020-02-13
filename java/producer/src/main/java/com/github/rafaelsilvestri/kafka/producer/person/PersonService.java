package com.github.rafaelsilvestri.kafka.producer.person;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * A business rules class to handle person entity.
 *
 * @author Rafael Silvestri
 */
@Service
public class PersonService {

    private PersonPublisher publisher;
    private ObjectMapper mapper;

    public PersonService(PersonPublisher publisher, ObjectMapper mapper) {
        this.publisher = publisher;
        this.mapper = mapper;
    }

    public Person save(Person person) {
        person.setId(UUID.randomUUID());

        try {
            publisher.publish(mapper.writeValueAsString(person));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return person;
    }


}
