package ru.converter.database.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ru.converter.oauthdb.repositories", entityManagerFactoryRef = "entityManagerFactoryBean")
public abstract class AbstractHibernateConfig {


    private static final String ENTITY_PACKAGE = "ru.converter.oauthdb.domains";

    private static final String JDBC_URL = "jdbc.url";
    private static final String JDBC_USERNAME = "jdbc.username";
    private static final String JDBC_PASSWORD = "jdbc.password";
    private static final String JDBC_DRIVER_CLASS_NAME = "jdbc.driverClassName";
    private static final String MAXIMUM_POOL_SIZE = "hibernate.hikari.maximumPoolSize";
    private static final String IDLE_TIMEOUT = "hibernate.hikari.idleTimeout";
    private static final String POOL_NAME = "hibernate.hikari.poolName";

    // HIBERNATE
    private static final String HIBERNATE_DIALECT = "hibernate.dialect";
    private static final String HIBERNATE_SHOW_SQL = "hibernate.show_sql";
    private static final String HIBERNATE_FORMAT_SQL = "hibernate.format_sql";
    private static final String HIBERNATE_DDL_AUTO = "hibernate.hbm2ddl.auto";
    private static final String HIBERNATE_VALIDATION_FACTORY = "javax.persistence.validation.factory";




    private Properties hibernateProperties(Environment environment) {
        Properties properties = new Properties();
        properties.put(HIBERNATE_DIALECT, environment.getRequiredProperty(HIBERNATE_DIALECT));
        properties.put(HIBERNATE_SHOW_SQL, environment.getRequiredProperty(HIBERNATE_SHOW_SQL));
        properties.put(HIBERNATE_FORMAT_SQL, environment.getRequiredProperty(HIBERNATE_FORMAT_SQL));
        properties.put(HIBERNATE_DDL_AUTO, environment.getRequiredProperty(HIBERNATE_DDL_AUTO));
        return properties;
    }

    @Bean
    public DataSource dataSource(Environment environment) {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(environment.getRequiredProperty(JDBC_URL));
        config.setUsername(environment.getRequiredProperty(JDBC_USERNAME));
        config.setPassword(environment.getRequiredProperty(JDBC_PASSWORD));
        config.setDriverClassName(environment.getRequiredProperty(JDBC_DRIVER_CLASS_NAME));
        config.setMaximumPoolSize(environment.getRequiredProperty(MAXIMUM_POOL_SIZE, Integer.TYPE));
        config.setIdleTimeout(environment.getRequiredProperty(IDLE_TIMEOUT, Long.TYPE));
        config.setPoolName(environment.getRequiredProperty(POOL_NAME));
        return new HikariDataSource(config);
    }

    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean entityManagerFactoryBean) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactoryBean.getObject());

        return transactionManager;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource, Environment environment) {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan(ENTITY_PACKAGE);

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.setJpaProperties(hibernateProperties(environment));

        return factoryBean;
    }


}