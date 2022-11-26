package com.gianfcop.ssd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		
	}
    
	@Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
