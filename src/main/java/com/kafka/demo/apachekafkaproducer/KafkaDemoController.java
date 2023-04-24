package com.kafka.demo.apachekafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
public class KafkaDemoController {

    @Autowired
    KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "NewTopic";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Book book) {
        //sending message to the Topic "NewTopic using kafkaTemplate;
        kafkaTemplate.send(TOPIC, book);

        return "Published successfully!";
    }
}
