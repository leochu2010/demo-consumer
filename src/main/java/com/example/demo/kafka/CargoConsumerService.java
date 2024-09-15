package com.example.demo.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class CargoConsumerService {

    private final Logger logger = LoggerFactory.getLogger(CargoConsumerService.class);

    private String localhost;

    @PostConstruct
    public void postConstructRoutine() throws UnknownHostException {
        // initialize parameters
        localhost = InetAddress.getLocalHost().toString();
    }

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CargoRepository cargoRepository;

    @Value("${kafka.topic.cargo}")
    private String cargoTopic;

    @KafkaListener(topics = {"${kafka.topic.cargo}"}, groupId = "cargo-group")
    public void consumeMessage(ConsumerRecord<String, String> cargoConsumerRecord) {
        try {
            Cargo cargo = objectMapper.readValue(cargoConsumerRecord.value(), Cargo.class);
            cargo.setConsumerAddress(localhost);
            cargoRepository.save(cargo);

            logger.info("consume [TOPIC: {}] [PARTITION: {}] -> [CARGO: {}]", cargoConsumerRecord.topic(), cargoConsumerRecord.partition(), cargo.toString());
        } catch (JsonProcessingException e) {
            logger.error("Failed to consume", e);
        }
    }

    public Iterable<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

}
