package com.github.rafaelsilvestri.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {

 //   @Autowired
    KafkaTemplate<Integer, String> template;

//    @Test
    public void send() {
        template.send("topic1", 0, "It Works!!!");

        template.flush();
    }

}