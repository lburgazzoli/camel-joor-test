package com.example;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

public class WithCustomProcessor extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        Processor ucp = new Processor() {
            public void process(Exchange exchange) throws Exception {
                String body = exchange.getIn().getBody(String.class);
                body = body.toUpperCase();
                exchange.getOut().setBody(body);
            }
        };

        from("timer:tick?period=10s")
              .setBody().constant("Hello")
            .process(ucp)
            .to("log:info");
    }
}