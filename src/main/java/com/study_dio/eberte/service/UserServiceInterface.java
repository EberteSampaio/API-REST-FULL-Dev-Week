package com.study_dio.eberte.service;

import com.study_dio.eberte.domain.entity.User;

import java.util.List;

public interface UserServiceInterface {

    List<User> all();

    User findById(Long id);

    User create(User user);
}
