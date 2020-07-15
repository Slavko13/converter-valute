package ru.converter.valuteapiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.converter.valuteapiserver.services.ValuteDownloaderService;

@SpringBootApplication(scanBasePackages = "ru.converter")
public class ValuteApiServerApplication {


	public static void main(String[] args) {

		SpringApplication.run(ValuteApiServerApplication.class, args);

	}

}
