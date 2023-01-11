package com.example.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "my_new_topic", groupId = "consumers")
    public void listenGroupConsumers1(
            @Payload String message,
            @Header(value = KafkaHeaders.RECEIVED_TOPIC, required = false) String topicName,
            @Header(value = KafkaHeaders.GROUP_ID, required = false) String groupId,
            @Header(value = KafkaHeaders.RECEIVED_PARTITION, required = false) String partitionId) {
        System.out.printf("Received Message: %s. from topic: %s, group: %s, partition: %s %n",
                message, topicName, groupId, partitionId);
    }

    @KafkaListener(topics = "my_topic", groupId = "consumers")
    public void listenGroupConsumers2(
            @Payload String message,
            @Header(value = KafkaHeaders.RECEIVED_TOPIC, required = false) String topicName,
            @Header(value = KafkaHeaders.GROUP_ID, required = false) String groupId,
            @Header(value = KafkaHeaders.RECEIVED_PARTITION, required = false) String partitionId) {
        System.out.printf("Received Message: %s. from topic: %s, group: %s, partition: %s %n",
                message, topicName, groupId, partitionId);
    }
}
