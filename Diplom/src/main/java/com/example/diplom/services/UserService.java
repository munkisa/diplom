package com.example.diplom.services;

import com.example.diplom.entities.UserEntity;
import com.example.diplom.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

    public UserEntity getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            throw new UsernameNotFoundException("Current user not found");
        }

        String username = authentication.getName();
        return findByEmail(username);
    }

    public UserEntity findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User: " + email + " not found"));
    }

}
