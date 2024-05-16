package com.example.diplom.security;


import com.example.diplom.entities.UserEntity;
import com.example.diplom.repositories.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepo userRepo;
    @Override
    @Transactional
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userRepo.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(
                        "User with email '"+email+"' not found"));
        return UserDetailsImpl.build(userEntity);
    }
}

