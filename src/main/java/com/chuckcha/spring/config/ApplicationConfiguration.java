package com.chuckcha.spring.config;

import com.chuckcha.spring.database.pool.ConnectionPool;
import com.chuckcha.spring.database.repository.CrudRepository;
import com.chuckcha.spring.database.repository.UserRepository;
import com.chuckcha.spring.service.CompanyService;
import com.chuckcha.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

//@ImportResource("classpath:application.xml")
@Import(WebConfiguration.class)
@Configuration(proxyBeanMethods = true)
public class ApplicationConfiguration {
}