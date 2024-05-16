package com.example.diplom.repositories;

import com.example.diplom.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    //@Query("SELECT email FROM diplom WHERE email = :email")
    Optional<UserEntity> findByEmail(String username);
}
