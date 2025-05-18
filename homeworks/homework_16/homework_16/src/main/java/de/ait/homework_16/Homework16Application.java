package de.ait.homework_16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homework16Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Homework16Application.class, args);
//		context.getBean("restTemplateBuilder");
//		System.out.println("qwert");
	}
}
