package com.chuckcha.spring.service;

import com.chuckcha.spring.database.repository.CrudRepository;
import com.chuckcha.spring.database.repository.CompanyRepository;
import com.chuckcha.spring.database.repository.UserRepository;
import com.chuckcha.spring.database.entity.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CrudRepository<Integer, Company> companyRepository;

}

