package com.bank.poc.rabbitmq;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;


@Component
public class RabbitMQRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:test_camel").id("routing_key")
                .to("rabbitmq://localhost:5672/test_exchange?queue=queue_test&autoDelete=false").end();
    }
}
