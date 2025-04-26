package com.chuckcha.spring.database.repository;

import com.chuckcha.spring.database.pool.ConnectionPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;


@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class UserRepository {

    @Qualifier("pool1")
    private final ConnectionPool connectionPool;

}
