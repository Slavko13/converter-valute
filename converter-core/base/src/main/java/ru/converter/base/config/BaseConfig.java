package ru.converter.base.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootConfiguration
@ComponentScan(basePackages = {"ru.converter"})
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "file:./application.properties", ignoreResourceNotFound = true),
})

public class BaseConfig {

}
