package com.fanx.springcloud.eureka.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloProducerController {
    @Value("${server.port}")
    private String port;

    @GetMapping("say-hello")
    public String sayHello(){
        return "this is " + port;
    }

    @PostMapping("say-hello")
    public Friend sayHelloPost(@RequestBody Friend friend) {
        log.info("You are "+friend.getName());
        friend.setPort(port);
        return friend;
    }
}
