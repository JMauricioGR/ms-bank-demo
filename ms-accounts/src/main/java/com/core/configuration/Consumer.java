package com.core.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final Logger log = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = {"${msaccounts.queue.name}"})
    public void receive(@Payload String message) {
        log.info("Received message {}", message);
    }
}