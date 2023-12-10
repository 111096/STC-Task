package com.stc.stcfiletask.service.impl;

import com.stc.stcfiletask.entity.PermissionEntity;
import com.stc.stcfiletask.enumeration.PermissionEnum;
import com.stc.stcfiletask.repository.PermissionRepository;
import com.stc.stcfiletask.service.UserAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAuthorityServiceImpl implements UserAuthorityService {

    @Autowired
    private PermissionRepository permissionRepository;


    @Override
    public boolean checkIfUserAuthorized(String userName, PermissionEnum permissionEnum, Long permissionGroupId) throws Exception {
       Optional<PermissionEntity> permissionEntity=permissionRepository.findByUserEmailAndPermissionLevel(userName,permissionEnum.getValue());
        return permissionEntity.isPresent();
    }
}

