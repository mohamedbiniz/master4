package com.master4.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;


@Configuration
@EnableJpaRepositories(basePackages = "com.master4.repositories")
@PropertySource("classpath:database.properties")
public class AppContext {

    @Autowired
    private Environment environment;

    public AppContext() {
        super();
    }

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.DriverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.Url"));
        dataSource.setUsername(environment.getProperty("jdbc.Username"));
        dataSource.setPassword(environment.getProperty("jdbc.Password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(){
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean=new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPackagesToScan(new String[]{
                "com.master4.entities"
        });
        HibernateJpaVendorAdapter vendorAdapter=new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaProperties(additionalProperties());
        return  entityManagerFactoryBean;
    }

    private Properties additionalProperties() {
        Properties properties=new Properties();
        properties.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emt){
        JpaTransactionManager transactionManager=new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emt);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
