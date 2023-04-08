package com.stc.boot.service.impl;

import com.stc.boot.dto.PermissionDto;
import com.stc.boot.entity.Permission;
import com.stc.boot.repository.PermissionRepository;
import com.stc.boot.service.GroupService;
import com.stc.boot.service.PermissionService;
import com.stc.boot.transform.DtoTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private PermissionRepository permissionRepository;
    private DtoTransformer permissionTransformer;
    private GroupService groupService;

    public PermissionServiceImpl(PermissionRepository permissionRepository, DtoTransformer permissionTransformer, GroupService groupService) {
        this.permissionRepository = permissionRepository;
        this.permissionTransformer = permissionTransformer;
        this.groupService = groupService;
    }

    @Override
    public PermissionDto findById(Long id) {
        return permissionTransformer.transformPermissionFromEntityToDto(permissionRepository.findById(id).get());
    }

    @Override
    public PermissionDto findByName(String name) {
        return permissionTransformer.transformPermissionFromEntityToDto(permissionRepository.findByName(name).get());
    }

    @Override
    public PermissionDto savePermission(PermissionDto permissionDto) {
        permissionDto.setGroup(groupService.findById(permissionDto.getGroup().getId()));
        Permission permission = permissionTransformer.transformPermissionFromDtoToEntity(permissionDto);
        permission = permissionRepository.save(permission);
        return permissionTransformer.transformPermissionFromEntityToDto(permission);
    }

    @Override
    public PermissionDto updatePermission(PermissionDto permissionDto) {
        PermissionDto updatedPermission = findById(permissionDto.getId());
        permissionDto.setGroup(groupService.findById(permissionDto.getGroup().getId()));
        updatedPermission.setName(permissionDto.getName());
        updatedPermission.setGroup(permissionDto.getGroup());
        Permission permission = permissionTransformer.transformPermissionFromDtoToEntity(updatedPermission);
        permission = permissionRepository.save(permission);
        return permissionTransformer.transformPermissionFromEntityToDto(permission);
    }

    @Override
    public String deletePermissionById(Long id) {
        PermissionDto deletedPermission = findById(id);
        if (deletedPermission == null)
            return "Permission Not Found Sucessfully";

        permissionRepository.delete(permissionTransformer.transformPermissionFromDtoToEntity(deletedPermission));
        return "Permission Deleted Sucessfully";
    }

    @Override
    public List<PermissionDto> findAll() {
        return permissionTransformer.transformPermissionFromListEntityToDto(permissionRepository.findAll());
    }
}
