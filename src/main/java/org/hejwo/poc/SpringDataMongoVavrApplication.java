package org.hejwo.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import io.vavr.jackson.datatype.VavrModule;

@SpringBootApplication
@Configuration
public class SpringDataMongoVavrApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataMongoVavrApplication.class, args);
	}

	@Bean
	public Jackson2ObjectMapperBuilder builderCustomizer() {
		return Jackson2ObjectMapperBuilder.json().modules(new VavrModule());
	}
}
