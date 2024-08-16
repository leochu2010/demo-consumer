package com.example.demo.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class BookProducerService {

    private static final Logger logger = LoggerFactory.getLogger(BookProducerService.class);

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public BookProducerService(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, Object o) {
        try {
            SendResult<String, Object> sendResult = kafkaTemplate.send(topic, o).get();
            if (sendResult.getRecordMetadata() != null) {
                logger.info("生产者成功发送消息到" + sendResult.getProducerRecord().topic() + "-> " + sendResult.getProducerRecord().value().toString());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
