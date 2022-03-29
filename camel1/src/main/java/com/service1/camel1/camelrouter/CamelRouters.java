package com.service1.camel1.camelrouter;

import com.service1.camel1.DemoBeans;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelRouters extends RouteBuilder {

  @Autowired
  DemoBeans demoBeans;

  public static final String route = "direct:pardhu-active-mq";

  @Override
  public void configure() throws Exception {
    from(route)
        .bean(demoBeans,"toJSON")
        .log("${body}")
        .to("activemq:pardhu-demo");
  }
}
