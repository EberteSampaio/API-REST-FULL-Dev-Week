package com.study_dio.eberte.domain.repository;

import com.study_dio.eberte.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccount_Number(String accountNumber);
}
