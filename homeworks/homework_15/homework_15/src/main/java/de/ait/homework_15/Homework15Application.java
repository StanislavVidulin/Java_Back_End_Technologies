package de.ait.homework_15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homework15Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Homework15Application.class, args);
//		context.getBean("restTemplateBuilder");
		System.out.println("qwert");
	}

}
