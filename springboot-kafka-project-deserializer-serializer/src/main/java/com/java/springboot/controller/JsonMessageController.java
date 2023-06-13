package com.java.springboot.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.java.springboot.kafka.KafkaProducer;
import com.java.springboot.payload.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    private KafkaProducer kafkaProducer;
    private ObjectMapper objectMapper;

    public JsonMessageController(KafkaProducer kafkaProducer, ObjectMapper objectMapper) {
        this.kafkaProducer = kafkaProducer;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        try {
            String jsonMessage = objectMapper.writeValueAsString(user);
            kafkaProducer.sendMessage(jsonMessage);
            return ResponseEntity.ok("Message sent to Kafka topic");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send message to Kafka");
        }
    }
}
