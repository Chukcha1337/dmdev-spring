package com.chuckcha.spring.validation;

import com.chuckcha.spring.validation.impl.UserInfoValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UserInfoValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserInfo {

    String message() default "Firstname or lastname should be filled in";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}