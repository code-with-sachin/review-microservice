package com.sachinsk.review_microservice.review.messaging;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    /*
    * This is a configuration class. For setting up rabbitmq in this spring application

    * This class will allow us to define the beans

    * We are going to have 3 method definitions here:
        1) 1 method is going to create a queue
        2) Another method is going to do message conversion - to JSON format..
        * So will be Serializing & Deserializing the messaged
        3) Another method, that will give us an instance of rabbit Template
        * Rabbit Template is a helper class
    *
    */

    @Bean
    public Queue companyRatingQueue(){
        return new Queue("companyRatingQueue");
    }

    @Bean
    public MessageConverter jsonMessageConvertor() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConvertor());
        return rabbitTemplate;
    }
}
