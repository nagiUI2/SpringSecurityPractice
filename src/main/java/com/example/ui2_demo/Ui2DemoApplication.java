package com.example.ui2_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class Ui2DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ui2DemoApplication.class, args);
	}

}
