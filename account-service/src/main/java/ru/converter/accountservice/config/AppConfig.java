package ru.converter.accountservice.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import ru.converter.base.config.BaseConfig;

@SpringBootConfiguration
@Import({HibernateConfig.class, BaseConfig.class, RabbitmqConfig.class})
public class AppConfig {

}
