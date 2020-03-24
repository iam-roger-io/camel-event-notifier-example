package com.consulting.fuse.poc;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;


@Configuration
@EnableConfigurationProperties
@ConfigurationProperties

@SpringBootApplication
@ImportResource({"classpath:spring/camelContext.xml"})
@PropertySource("classpath:application.properties")
public class Application {
	
    public static void main(String[] args) {
        org.springframework.context.ApplicationContext ctx = org.springframework.boot.SpringApplication.run(Application.class, args);
    }
}
