package com.yiming.restServer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.util.Arrays;

@SpringBootApplication

public class RestServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestServerApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");
			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}


		};
	}


	@Bean
    public WebMvcConfigurer corsConfigurer(){
	    return new WebMvcConfigurer () {
	        @Override
            public void addCorsMappings(CorsRegistry registry){
                registry.addMapping("/users")
                        .allowedMethods("*").allowedHeaders("*").allowedOrigins("*");
            }
        };
    }

	@Bean
    public ModelMapper modelMapper(){
	    return new ModelMapper();
    }
}
