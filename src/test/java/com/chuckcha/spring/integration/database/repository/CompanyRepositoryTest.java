package com.chuckcha.spring.integration.database.repository;

import com.chuckcha.spring.ApplicationRunner;
import com.chuckcha.spring.database.entity.Company;
import com.chuckcha.spring.database.repository.CompanyRepository;
import com.chuckcha.spring.integration.IntegrationTestBase;
import com.chuckcha.spring.integration.annotation.IT;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
//@Transactional
//@Commit
class CompanyRepositoryTest extends IntegrationTestBase {

    public static final Integer APPLE_ID = 5;
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
        var company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);

        });
    }

    @Test
    @Disabled
    void delete() {
        Optional<Company> maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }


    @Test
    void save() {
        var company = Company.builder()
                .name("Apple1")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }

    @Test
    void checkFindByQueries() {
    companyRepository.findByName("Google");
    companyRepository.findAllByNameContainingIgnoreCase("a");

    }
}