package com.cyh.muaiagent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cyh"})
public class MuAiAgentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuAiAgentApplication.class, args);
    }

}
