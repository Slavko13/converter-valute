package ru.converter.emailserver.config;


import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import ru.converter.base.config.BaseConfig;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

@SpringBootConfiguration
@Import({RabbitMqConfig.class, BaseConfig.class})
public class AppConfig {

    private static final String HOST = "spring.mail.host";
    private static final String PORT = "spring.mail.port";
    private static final String USERNAME = "spring.mail.username";
    private static final String PASSWORD = "spring.mail.password";
    private static final String PROTOCOL = "spring.mail.protocol";
    private static final String DEBUG = "mail.debug";

    private static final String HTML_RESOLVER_PREFIX = "/emailTemplates/";
    private static final String HTML_RESOLVER_SUFFIX = ".html";


    @Bean(name = "getJavaMailSender")
    public JavaMailSender getJavaMailSender(Environment environment) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(environment.getRequiredProperty(HOST));
        mailSender.setPort(environment.getRequiredProperty(PORT, Integer.TYPE));
        mailSender.setUsername(environment.getRequiredProperty(USERNAME));
        mailSender.setPassword(environment.getRequiredProperty(PASSWORD));
        //mailSender.setProtocol(environment.getProperty(PROTOCOL));

        Properties properties = mailSender.getJavaMailProperties();

        //properties.setProperty("mail.transport.protocol", environment.getRequiredProperty(PROTOCOL));
        properties.setProperty("mail.debug", environment.getRequiredProperty(DEBUG));
        properties.setProperty("mail.smtp.ssl.trust", "smtp.mail.ru");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        return mailSender;
    }

    @Bean
    public ITemplateEngine emailTemplateEngine(MessageSource messageSource) {
        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());
        templateEngine.setTemplateEngineMessageSource(messageSource);
        return templateEngine;
    }

    private ITemplateResolver htmlTemplateResolver() {
        final ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setPrefix(HTML_RESOLVER_PREFIX);
        templateResolver.setSuffix(HTML_RESOLVER_SUFFIX);
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
        templateResolver.setCacheable(false);
        return templateResolver;
    }


}
