package com.chuckcha.spring.service;

import com.chuckcha.spring.database.repository.CompanyRepository;
import com.chuckcha.spring.database.repository.UserRepository;
import com.chuckcha.spring.database.entity.Company;
import com.chuckcha.spring.dto.UserCreateEditDto;
import com.chuckcha.spring.dto.UserFilter;
import com.chuckcha.spring.dto.UserReadDto;
import com.chuckcha.spring.mapper.UserCreateEditMapper;
import com.chuckcha.spring.mapper.UserReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

//    public Page<UserReadDto> findAll(UserFilter filter, Pageable pageable) {
//        var predicate = QPredicates.builder()
//                .add(filter.firstname(), user.firstname::containsIgnoreCase)
//                .add(filter.lastname(), user.lastname::containsIgnoreCase)
//                .add(filter.birthDate(), user.birthDate::before)
//                .build();
//
//        return userRepository.findAll(predicate, pageable)
//                .map(userReadMapper::map);
//    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto userDto) {
        return Optional.of(userDto)
                .map(userCreateEditMapper::map)
                .map(userRepository::save)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto userDto) {
        return userRepository.findById(id)
                .map(entity -> userCreateEditMapper.map(userDto, entity))
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(entity -> {
                    userRepository.delete(entity);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }
}


