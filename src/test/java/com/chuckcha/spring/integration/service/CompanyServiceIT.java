package com.chuckcha.spring.integration.service;

import com.chuckcha.spring.config.DatabaseProperties;
import com.chuckcha.spring.dto.CompanyReadDto;
import com.chuckcha.spring.service.CompanyService;
import com.chuckcha.spring.integration.annotation.IT;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = ApplicationRunner.class, initializers = ConfigDataApplicationContextInitializer.class)
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

//    @Test
//    @Disabled
//    void findById() {
//        var actualResult = companyService.findById(COMPANY_ID);
//
//        assertTrue(actualResult.isPresent());
//
//        var expectedResult = new CompanyReadDto(COMPANY_ID,null);
//        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
//    }
}