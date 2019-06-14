package io.github.jhipster.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class JhipsterSampleApplication1KafkaProducer {

    private static final Logger log = LoggerFactory.getLogger(JhipsterSampleApplication1KafkaProducer.class);
    private static final String TOPIC = "topic_jhipstersampleapplication1";

    private KafkaTemplate<String, String> kafkaTemplate;

    public JhipsterSampleApplication1KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        log.info("Producing message to {} : {}", TOPIC, message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
