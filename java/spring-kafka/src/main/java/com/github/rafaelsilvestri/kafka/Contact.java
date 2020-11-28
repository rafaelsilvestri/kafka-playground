package com.github.rafaelsilvestri.kafka;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Contact {

  private UUID id;
  private String name;
  private String email;

}
