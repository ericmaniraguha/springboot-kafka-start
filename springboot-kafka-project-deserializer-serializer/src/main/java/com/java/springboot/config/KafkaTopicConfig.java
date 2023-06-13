package com.java.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {
   
    @Bean
    public NewTopic javaguidesTopic() {
        return new NewTopic("javaguides", 3, (short) 3);
    }
}
