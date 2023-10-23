package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByFirstPhone(String phone);
    boolean existsByFirstPhone(String phone);

    Optional<User> findBySecondPhone(String phone);
    boolean existsBySecondPhone(String phone);

    void deleteByFirstPhone(String phone);
    void deleteBySecondPhone(String phone);
}
