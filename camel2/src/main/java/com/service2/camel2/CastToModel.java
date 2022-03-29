package com.service2.camel2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.service2.camel2.model.DemoModel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class CastToModel implements Processor {
  public void process(Exchange exchange) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    DemoModel demo = mapper.readValue(exchange.getMessage().getBody().toString(),DemoModel.class);
    System.out.println(demo.toString());
  }
}
