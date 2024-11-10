package com.study_dio.eberte.service.impl;

import com.study_dio.eberte.domain.entity.User;
import com.study_dio.eberte.domain.repository.UserRepository;
import com.study_dio.eberte.infra.exceptions.UserAccountNumberExistsException;
import com.study_dio.eberte.infra.exceptions.UserNotFoundException;
import com.study_dio.eberte.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    public List<User> all(){
        return this.userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public User create(User user) {

        if(this.userRepository.existsByAccount_Number(user.getAccount().getNumber()))
            throw new UserAccountNumberExistsException(user.getAccount().getNumber());

        return this.userRepository.save(user);
    }
}
