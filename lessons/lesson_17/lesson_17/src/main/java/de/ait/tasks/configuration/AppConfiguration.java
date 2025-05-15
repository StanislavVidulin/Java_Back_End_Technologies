package de.ait.tasks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfiguration {

    @Bean
    public Scanner getMyScanner(){
        System.out.println("1234567890-df");
        return new Scanner(System.in);
    }

}
