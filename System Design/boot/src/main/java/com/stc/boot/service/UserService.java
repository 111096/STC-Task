package com.stc.boot.service;

import com.stc.boot.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id);

    UserDto findByEmail(String email);

    UserDto findByUsername(String username);

    UserDto findByUsernameOrEmail(String username, String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    UserDto saveUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    String deleteUserById(Long id);

    List<UserDto> findAll();
}
