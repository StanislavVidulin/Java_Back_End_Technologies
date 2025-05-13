package de.ait.hw2025_04_12_tasks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfiguration {

    @Bean
    public Scanner getMyScanner(){
        return new Scanner(System.in);
    }
}
