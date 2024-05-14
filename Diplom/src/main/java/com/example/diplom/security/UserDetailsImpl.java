package com.example.diplom.security;

import com.example.diplom.entities.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    private Long id;
    private String name;
    private String surname;
    private int pass_series;
    private int pass_id;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Long id, String name, String surname, int pass_series, int pass_id, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.pass_series = pass_series;
        this.pass_id = pass_id;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserDetailsImpl build(UserEntity userEntity) {
        List<GrantedAuthority> authorityList = List.of(new SimpleGrantedAuthority());
        return new UserDetailsImpl(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getSurname(),
                userEntity.getPass_series(),
                userEntity.getPass_id(),
                userEntity.getEmail(),
                userEntity.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
