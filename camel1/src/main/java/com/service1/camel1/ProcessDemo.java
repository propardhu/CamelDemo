package com.service1.camel1;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class ProcessDemo implements Processor {

  public void process(Exchange exchange) {
    System.out.println(exchange.getMessage().getBody());
  }

}
