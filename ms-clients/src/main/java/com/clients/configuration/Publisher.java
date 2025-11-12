package com.clients.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@EnableRabbit
public class Publisher {

    private RabbitTemplate rabbitTemplate;
    private Queue queue;

    public Publisher(RabbitTemplate rabbitTemplate, Queue queue) {
        this.rabbitTemplate = rabbitTemplate;
        this.queue = queue;
    }

    public void send(Object message) {
        rabbitTemplate.convertAndSend(queue.getName(), message);
    }
}
