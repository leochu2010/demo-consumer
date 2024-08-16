package com.example.demo.kafka;

import com.github.javafaker.Faker;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Cargo {

    private static final Faker faker = new Faker();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime localDateTime = LocalDateTime.now();
    private String name = faker.name().fullName();
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String streetAddress = faker.address().streetAddress();
    private String producerAddress;
    private String consumerAddress;

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProducerAddress() {
        return producerAddress;
    }

    public void setProducerAddress(String producerAddress) {
        this.producerAddress = producerAddress;
    }

    public String getConsumerAddress() {
        return consumerAddress;
    }

    public void setConsumerAddress(String consumerAddress) {
        this.consumerAddress = consumerAddress;
    }

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", localDateTime=" + localDateTime +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", producerAddress='" + producerAddress + '\'' +
                ", consumerAddress='" + consumerAddress + '\'' +
                '}';
    }
}
