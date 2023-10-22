package com.example.spduamnfirnbrxxaoouf.repository;

import com.example.spduamnfirnbrxxaoouf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
