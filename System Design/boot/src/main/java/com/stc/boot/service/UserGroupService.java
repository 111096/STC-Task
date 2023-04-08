package com.stc.boot.service;

import com.stc.boot.dto.UserDto;
import com.stc.boot.dto.UserGroupDto;

import java.util.List;

public interface UserGroupService {

    UserGroupDto findById(Long id);

    UserGroupDto saveUser(UserGroupDto userDto);

    UserGroupDto updateUser(UserGroupDto userDto);

    String deleteUserById(Long id);

    List<UserGroupDto> findAll();
}
