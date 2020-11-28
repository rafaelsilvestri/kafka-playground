package com.github.rafaelsilvestri.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(exclude = {
    DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class,
    HibernateJpaAutoConfiguration.class
})
@Slf4j
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  /**
   * The code sniped below shows how kafka can deal with race conditions. Using the key (user id)
   * kafka ensure that events that belongs to the same user (user id) will be published to the same
   * partition and every partition is being consumed by a single consumer.
   *
   * @param template     publisher
   * @param objectMapper used to convert an object to json.
   * @return
   */
  @Bean
  public CommandLineRunner run(KafkaTemplate<String, String> template, ObjectMapper objectMapper) {
    return (args) -> {
      final List<Contact> contactList = new ArrayList<>();

      log.info("Publishing 'I' events...");
      for (int i = 0; i < 10; i++) {
        Contact contact = Contact.builder().id(UUID.randomUUID()).name("Contact " + i)
            .email("contact" + i + "@foo.com").build();
        contactList.add(contact);

        ContactEvent event = ContactEvent.builder().type("I").contact(
            contact).build();

        template.send("contact-topic", contact.getId().toString(),
            objectMapper.writeValueAsString(event));
      }

      log.info("Publishing 'U' events...");
      for (Contact contact : contactList) {
        ContactEvent event = ContactEvent.builder().type("U").contact(
            contact).build();

        template.send("contact-topic", contact.getId().toString(),
            objectMapper.writeValueAsString(event));
      }

      log.info("Publishing 'D' events...");
      for (Contact contact : contactList) {
        ContactEvent event = ContactEvent.builder().type("D").contact(
            contact).build();

        template.send("contact-topic", contact.getId().toString(),
            objectMapper.writeValueAsString(event));
      }

    };
  }

}
