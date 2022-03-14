package io.sb.demorestclient;

import io.sb.demorestclient.resttemplate.RestTemplateDemo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoRestclientApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(DemoRestclientApplication.class, args);
        RestTemplateDemo restTemplateDemo = applicationContext.getBean(RestTemplateDemo.class);
        restTemplateDemo.fetchTheData();
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
