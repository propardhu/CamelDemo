package com.service1.camel1;

import static com.service1.camel1.camelrouter.CamelRouters.route;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.service1.camel1.model.DemoModel;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  private ProducerTemplate producerTemplate;

  @Autowired
  private CamelContext camelContext;

  @PostMapping("/send")
  public ResponseEntity<?> sendMessage(@RequestBody DemoModel message) throws JsonProcessingException {
    Exchange exchange = ExchangeBuilder.anExchange(camelContext).withBody(message).build();
    producerTemplate.asyncSend(route,exchange);
    return ResponseEntity.ok("Done");
  }
}
