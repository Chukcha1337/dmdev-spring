package com.chuckcha.spring.listener.entity;

import com.chuckcha.spring.database.entity.Company;
import lombok.Getter;

import java.util.EventObject;

public class EntityEvent extends EventObject {

    @Getter
    private final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }

}
