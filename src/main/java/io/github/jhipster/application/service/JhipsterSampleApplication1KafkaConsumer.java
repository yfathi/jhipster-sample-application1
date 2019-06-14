package io.github.jhipster.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JhipsterSampleApplication1KafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleApplication1KafkaConsumer.class);
    private static final String TOPIC = "topic_jhipstersampleapplication1";

    @KafkaListener(topics = "topic_jhipstersampleapplication1", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
