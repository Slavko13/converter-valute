package ru.converter.valuteconverterapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "ru.converter")
public class ValuteConverterApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ValuteConverterApiApplication.class, args);
	}

}
