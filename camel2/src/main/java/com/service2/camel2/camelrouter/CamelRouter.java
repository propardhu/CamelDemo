package com.service2.camel2.camelrouter;

import com.service2.camel2.CastToModel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

  @Autowired
  CastToModel castToModel;

  @Override
  public void configure() throws Exception{
    from("activemq:pardhu-demo")
        .process(castToModel);
  }

}
