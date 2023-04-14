package com.fanx.springcloud.eureka.client;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaClientProducerApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(EurekaClientProducerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
