package com.bank.poc.rabbitmq;

import com.rabbitmq.client.ConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    @Bean
    public ConnectionFactory createConnectionFactory() {
       ConnectionFactory connectionFactory = new ConnectionFactory();
       connectionFactory.setHost("localhost");
       connectionFactory.setPort(5672);
       connectionFactory.setPassword("guest");
       connectionFactory.setUsername("guest");
       return connectionFactory;
    }

}
