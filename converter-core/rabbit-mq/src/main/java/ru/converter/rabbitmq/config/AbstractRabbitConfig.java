package ru.converter.rabbitmq.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@EnableRabbit
public abstract class AbstractRabbitConfig {

    private static final String RABBIT_HOSTNAME = "rabbitmq.hostname";;
    private static final String RABBIT_USERNAME = "rabbitmq.username";
    private static final String RABBIT_PASSWORD = "rabbitmq.password";
    private static final String RABBIT_PORT = "rabbitmq.port";


    @Bean
    public ConnectionFactory connectionFactory(Environment environment) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(environment.getRequiredProperty(RABBIT_HOSTNAME));
        connectionFactory.setUsername(environment.getRequiredProperty(RABBIT_USERNAME));
        connectionFactory.setPassword(environment.getRequiredProperty(RABBIT_PASSWORD));
        connectionFactory.setPort(environment.getProperty(RABBIT_PORT, Integer.TYPE, 5672));
        return connectionFactory;
    }

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }


    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(ConnectionFactory connectionFactory,
                                                                               MessageConverter messageConverter) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setMaxConcurrentConsumers(5);
        factory.setMessageConverter(messageConverter);
        factory.setDefaultRequeueRejected(false);

        return factory;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setConnectionFactory(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }


}
