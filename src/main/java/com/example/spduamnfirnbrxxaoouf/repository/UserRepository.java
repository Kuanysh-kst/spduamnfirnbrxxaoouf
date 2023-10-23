package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDTO,Long> {
    Optional<UserDTO> findByFirstPhone(String phone);
    boolean existsByFirstPhone(String phone);

    Optional<UserDTO> findBySecondPhone(String phone);
    boolean existsBySecondPhone(String phone);

    void deleteByFirstPhone(String phone);
    void deleteBySecondPhone(String phone);
}
