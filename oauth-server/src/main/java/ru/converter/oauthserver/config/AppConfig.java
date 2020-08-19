package ru.converter.oauthserver.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import ru.converter.base.config.BaseConfig;

@SpringBootConfiguration
@Import({HibernateConfig.class, BaseConfig.class, RabbitConfig.class})
public class AppConfig {
}
