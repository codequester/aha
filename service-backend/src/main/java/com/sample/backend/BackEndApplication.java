package com.sample.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BackEndApplication 
{
    public static void main( String[] args ){
        SpringApplication.run(BackEndApplication.class, args);
    }
}
