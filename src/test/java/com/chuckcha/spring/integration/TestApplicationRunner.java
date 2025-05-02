package com.chuckcha.spring.integration;

import com.chuckcha.spring.database.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoSpyBean;

@TestConfiguration
public class TestApplicationRunner {

    @MockitoSpyBean(name = "pool1")
    private ConnectionPool pool1;
}
