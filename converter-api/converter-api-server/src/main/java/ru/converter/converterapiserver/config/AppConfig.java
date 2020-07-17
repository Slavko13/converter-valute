package ru.converter.converterapiserver.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import ru.converter.base.config.BaseConfig;

@SpringBootConfiguration
@Import({RabbitConfig.class, BaseConfig.class, HibernateConfig.class})
public class AppConfig {


}
