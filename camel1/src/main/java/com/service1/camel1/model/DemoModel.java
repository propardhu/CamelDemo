package com.service1.camel1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class DemoModel implements Serializable {
  @JsonProperty("name")
  String name;
  @JsonProperty("message")
  String message;
}
