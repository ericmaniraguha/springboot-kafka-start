package com.java.springboot.kafka;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.java.springboot.payload.User;

@Service
public class JsonKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "javaguides_json",
            groupId = "myGroup")
public void consume(User data){
LOGGER.info(String.format("JSON Message received -> %s", data.toString()));
}
}