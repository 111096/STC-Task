package com.stc.boot.service.impl;

import com.stc.boot.dto.UserGroupDto;
import com.stc.boot.repository.UserGroupRepository;
import com.stc.boot.service.UserGroupService;
import com.stc.boot.transform.DtoTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserGroupImpl implements UserGroupService {

    private UserGroupRepository userRepository;
    private DtoTransformer userTransformer;

    public UserGroupImpl(UserGroupRepository userRepository, DtoTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    @Override
    public UserGroupDto findById(Long id) {
        return userTransformer.transformUserGroupFromEntityToDto(userRepository.findById(id).get());
    }

    @Override
    public UserGroupDto saveUser(UserGroupDto userDto) {
        return userTransformer.transformUserGroupFromEntityToDto(userRepository.save(userTransformer.transformUserGroupFromDtoToEntity(userDto)));
    }

    @Override
    public UserGroupDto updateUser(UserGroupDto userDto) {
        UserGroupDto updatedUser = findById(userDto.getId());
        updatedUser.setUser(userDto.getUser());
        updatedUser.setGroup(userDto.getGroup());
        return userTransformer.transformUserGroupFromEntityToDto(userRepository.save(userTransformer.transformUserGroupFromDtoToEntity(updatedUser)));
    }

    @Override
    public String deleteUserById(Long id) {
        UserGroupDto deletedUser = findById(id);
        if (deletedUser == null)
            return "User Not Found Sucessfully";

        userRepository.delete(userTransformer.transformUserGroupFromDtoToEntity(deletedUser));
        return "User Deleted Sucessfully";
    }

    @Override
    public List<UserGroupDto> findAll() {
        return userTransformer.transformUserGroupFromListEntityToDto(userRepository.findAll());
    }
}
