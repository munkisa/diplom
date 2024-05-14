package com.example.diplom.security;

import com.example.diplom.entities.UserEntity;
import com.example.diplom.repositories.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(
                        "User with email '" + username + "' not found"
                ));
        return UserDetailsImpl.build(userEntity);
    }
}
