package com.stc.boot.security;

import com.stc.boot.dto.UserDto;
import com.stc.boot.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

    UserServiceImpl userService;

    @Autowired
    CustomUserDetailsService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto user = Optional.ofNullable(userService.findByUsernameOrEmail(username, username))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with email or username => " + username));

        Set<GrantedAuthority> authoritySet = user
                .getUserGroupDtoList()
                .stream()
                .map((userGroupDto) -> new SimpleGrantedAuthority(userGroupDto.getGroup().getName())).collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authoritySet);
    }
}
