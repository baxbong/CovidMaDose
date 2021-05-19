package com.baxbong.covidmadose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CovidMaDoseApplication {

    public static void main(String[] args) {

        SpringApplication.run(CovidMaDoseApplication.class, args);
    }

}
