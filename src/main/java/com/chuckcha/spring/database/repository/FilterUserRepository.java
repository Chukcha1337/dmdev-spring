package com.chuckcha.spring.database.repository;

import com.chuckcha.spring.database.entity.Role;
import com.chuckcha.spring.database.entity.User;
import com.chuckcha.spring.dto.PersonalInfo;
import com.chuckcha.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);

}
