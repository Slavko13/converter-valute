package ru.converter.valuteconverterapi.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.converter.base.config.BaseConfig;



@SpringBootConfiguration
@Import({HibernateConfig.class, BaseConfig.class})
public class AppConfig {

}
