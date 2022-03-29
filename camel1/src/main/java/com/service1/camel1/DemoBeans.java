package com.service1.camel1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component
public class DemoBeans {
  public String toJSON(Exchange exchange) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(exchange.getMessage().getBody());
  }
}
