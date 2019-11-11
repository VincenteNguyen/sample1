package com.sample.app.web.rest;

import com.sample.app.service.Sample1KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sample-1-kafka")
public class Sample1KafkaResource {

    private final Logger log = LoggerFactory.getLogger(Sample1KafkaResource.class);

    private Sample1KafkaProducer kafkaProducer;

    public Sample1KafkaResource(Sample1KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.send(message);
    }
}
