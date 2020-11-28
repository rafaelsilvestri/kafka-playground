package com.github.rafaelsilvestri.kafka;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaConfiguration {

  @Value(value = "${kafka.bootstrapServers:127.0.0.1:9092}")
  private String bootstrapServers;

  @Bean
  public KafkaAdmin kafkaAdmin() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    // additional properties!
    configs.put("key-serializer", "org.apache.kafka.common.serialization.StringSerializer");
    configs.put("value-serializer", "org.apache.kafka.common.serialization.StringSerializer");
    return new KafkaAdmin(configs);
  }

  @Bean
  public NewTopic contactTopic() {
    return TopicBuilder.name("contact-topic")
        .partitions(3)
        .replicas(1) //set according to the number of brokers in the cluster
        .build();
  }

  @Bean
  public NewTopic fooTopic() {
    return TopicBuilder.name("foo-topic")
        .partitions(1)
        .replicas(1) //set according to the number of brokers in the cluster
        .build();
  }
  
}
