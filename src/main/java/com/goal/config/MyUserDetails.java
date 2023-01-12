package com.goal.config;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.goal.entity.User;

import lombok.Data;

@Data
public class MyUserDetails implements UserDetails {
    private static final long serialVersionUID = 1L;

    final boolean accountNonExpired = true;
    final boolean accountNonLocked = true;
    final boolean credentialsNonExpired = true;
    final String password;
    final String username;
    final boolean isEnabled;
    Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

    final String name;
    final String email;

    public MyUserDetails(User user) {
        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        this.username = user.getUserId();
        this.password = user.getPassword();
        this.isEnabled = user.isEnabled();
        this.name = user.getName();
        this.email = user.getEmail();

    }
}
