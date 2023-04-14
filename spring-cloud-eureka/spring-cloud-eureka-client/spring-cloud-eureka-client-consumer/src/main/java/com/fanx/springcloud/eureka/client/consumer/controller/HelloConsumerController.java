package com.fanx.springcloud.eureka.client.consumer.controller;

import com.fanx.springcloud.eureka.client.consumer.entity.Friend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloConsumerController {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    LoadBalancerClient loadBalancerClient;

    @GetMapping("say-hello")
    public String sayHello(){
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        String url = String.format("http://%s:%s/say-hello", instance.getHost(), instance.getPort());
        return restTemplate.getForObject(url, String.class);

    }

    @PostMapping("say-hello")
    public Friend sayHelloPost(@RequestBody Friend friend) {
        ServiceInstance instance = loadBalancerClient.choose("eureka-client");
        String url = String.format("http://%s:%s/say-hello", instance.getHost(), instance.getPort());
        return restTemplate.postForObject(url, friend, Friend.class);
    }

}
