package com.stc.boot.service;


import com.stc.boot.dto.PermissionDto;

import java.util.List;

public interface PermissionService {

    PermissionDto findById(Long id);

    PermissionDto findByName(String name);

    PermissionDto savePermission(PermissionDto permissionDto);

    PermissionDto updatePermission(PermissionDto permissionDto);

    String deletePermissionById(Long id);

    List<PermissionDto> findAll();

}
