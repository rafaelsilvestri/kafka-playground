package com.github.rafaelsilvestri.kafka;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ContactEvent {

  private String type; // I,U,D
  private Contact contact;

}
