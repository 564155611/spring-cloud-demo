package com.fanx.springcloud.config;

import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@RibbonClient(name="eureka-client-producer", configuration = RoundRobinRule.class)
public class RibbonConfig {
  @Bean
  @LoadBalanced
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

//  @Bean
//  public IRule roundRobinRule(){
//    return new RoundRobinRule();
//  }
}
