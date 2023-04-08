package com.stc.boot.service.impl;

import com.stc.boot.dto.UserDto;
import com.stc.boot.repository.UserRepository;
import com.stc.boot.service.UserService;
import com.stc.boot.transform.DtoTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private DtoTransformer userTransformer;

    public UserServiceImpl(UserRepository userRepository, DtoTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    @Override
    public UserDto findById(Long id) {
        return userTransformer.transformUserFromEntityToDto(userRepository.findById(id).get());
    }

    @Override
    public UserDto findByEmail(String email) {
        return userTransformer.transformUserFromEntityToDto(userRepository.findByEmail(email).get());
    }

    @Override
    public UserDto findByUsername(String username) {
        return userTransformer.transformUserFromEntityToDto(userRepository.findByUsername(username).get());
    }

    @Override
    public UserDto findByUsernameOrEmail(String username, String email) {
        return userTransformer.transformUserFromEntityToDto(userRepository.findByUsernameOrEmail(username, email).get());
    }

    @Override
    public Boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        return userTransformer.transformUserFromEntityToDto(userRepository.save(userTransformer.transformUserFromDtoToEntity(userDto)));
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        UserDto updatedUser = findById(userDto.getId());
        updatedUser.setName(userDto.getName());
        updatedUser.setEmail(userDto.getEmail());
        updatedUser.setUsername(userDto.getUsername());
        updatedUser.setPassword(userDto.getPassword());
        updatedUser.setUserGroupDtoList(userDto.getUserGroupDtoList());
        return userTransformer.transformUserFromEntityToDto(userRepository.save(userTransformer.transformUserFromDtoToEntity(updatedUser)));
    }

    @Override
    public String deleteUserById(Long id) {
        UserDto deletedUser = findById(id);
        if (deletedUser == null)
            return "User Not Found Sucessfully";

        userRepository.delete(userTransformer.transformUserFromDtoToEntity(deletedUser));
        return "User Deleted Sucessfully";
    }

    @Override
    public List<UserDto> findAll() {
        return userTransformer.transformUserFromListEntityToDto(userRepository.findAll());
    }
}
