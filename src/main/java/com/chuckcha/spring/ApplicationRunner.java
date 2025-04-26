package com.chuckcha.spring;

import com.chuckcha.spring.config.ApplicationConfiguration;
import com.chuckcha.spring.database.pool.ConnectionPool;
import com.chuckcha.spring.database.repository.CompanyRepository;
import com.chuckcha.spring.database.repository.CrudRepository;
import com.chuckcha.spring.database.repository.UserRepository;
import com.chuckcha.spring.ioc.Container;
import com.chuckcha.spring.service.CompanyService;
import com.chuckcha.spring.service.UserService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

@SpringBootApplication
@ConfigurationPropertiesScan
public class ApplicationRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationRunner.class, args);
        System.out.println(context.getBeanDefinitionCount());
    }
}