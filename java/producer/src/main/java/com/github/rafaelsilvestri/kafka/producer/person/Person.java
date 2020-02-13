package com.github.rafaelsilvestri.kafka.producer.person;

import lombok.Data;

import java.util.UUID;

@Data
public class Person {

    private UUID id;
    private String name;
    private String email;
    private String address;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   /*
    {
        "name":"Rafael",
        "email":"rafaelcechinel@gmail.com",
        "address":"Boulevard Street"
    }
*/

}
