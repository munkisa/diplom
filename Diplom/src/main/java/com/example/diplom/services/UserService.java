package com.example.diplom.services;

import com.example.diplom.entities.UserEntity;
import com.example.diplom.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    UserRepo userRepo;
    private BCryptPasswordEncoder encoder(){return new BCryptPasswordEncoder();}
    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(encoder().encode(userEntity.getPassword()));
        userRepo.save(userEntity);
    }
}
