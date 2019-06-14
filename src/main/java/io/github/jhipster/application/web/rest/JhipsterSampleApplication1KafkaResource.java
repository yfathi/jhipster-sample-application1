package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.JhipsterSampleApplication1KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-sample-application-1-kafka")
public class JhipsterSampleApplication1KafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleApplication1KafkaResource.class);

    private JhipsterSampleApplication1KafkaProducer kafkaProducer;

    public JhipsterSampleApplication1KafkaResource(JhipsterSampleApplication1KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
