package com.fanx.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {
  @Autowired
  RestTemplate restTemplate;
  @Autowired
  LoadBalancerClient loadBalancerClient;

  @GetMapping("say-hello")
  public String sayHello(){
    String url = "http://eureka-client-producer/say-hello";
    return restTemplate.getForObject(url, String.class);

  }

}
