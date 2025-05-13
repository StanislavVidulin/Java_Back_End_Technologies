package de.ait.hw2025_04_12_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Hw20250412TasksApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Hw20250412TasksApplication.class, args);
//		context.getBean("restTemplateBuilder");
		System.out.println("qwert");
	}

}
