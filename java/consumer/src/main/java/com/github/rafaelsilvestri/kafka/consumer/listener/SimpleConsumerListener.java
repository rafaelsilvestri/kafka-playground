package com.github.rafaelsilvestri.kafka.consumer.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleConsumerListener {

    private static final Logger log = LoggerFactory.getLogger(SimpleConsumerListener.class);

    @KafkaListener(id = "simpleListener", topics = "topic1")
    public void onEventReceived(String event) {
        log.info("\n===== EVENT RECEIVED ====\n" +
                "[Event]: {}", event);
    }

}
