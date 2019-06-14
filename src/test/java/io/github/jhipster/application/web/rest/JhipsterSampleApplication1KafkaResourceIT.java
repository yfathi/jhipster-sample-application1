package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplication1App;
import io.github.jhipster.application.service.JhipsterSampleApplication1KafkaProducer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EmbeddedKafka
@SpringBootTest(classes = JhipsterSampleApplication1App.class)
public class JhipsterSampleApplication1KafkaResourceIT {

    @Autowired
    private JhipsterSampleApplication1KafkaProducer kafkaProducer;

    private MockMvc restMockMvc;

    @BeforeEach
    public void setup() {
        JhipsterSampleApplication1KafkaResource kafkaResource = new JhipsterSampleApplication1KafkaResource(kafkaProducer);

        this.restMockMvc = MockMvcBuilders.standaloneSetup(kafkaResource)
            .build();
    }

    @Test
    public void sendMessageToKafkaTopic() throws Exception {
        restMockMvc.perform(post("/api/jhipster-sample-application-1-kafka/publish?message=yolo"))
            .andExpect(status().isOk());
    }
}
