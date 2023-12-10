package com.stc.stcfiletask.transformer.impl;

import com.stc.stcfiletask.dto.common.PermissionGroupDTO;
import com.stc.stcfiletask.entity.PermissionEntity;
import com.stc.stcfiletask.entity.PermissionGroupEntity;
import com.stc.stcfiletask.transformer.Transformer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PermissionGroupTransformer implements Transformer<PermissionGroupEntity, PermissionGroupDTO> {

    @Override
    public PermissionGroupEntity transformDtoToEntity(PermissionGroupDTO groupDTO) {
       List<PermissionEntity> permissions= groupDTO.
                getPermissions().stream().map(PermissionEntity::new).collect(Collectors.toList());
        return PermissionGroupEntity.builder()
                .groupName(groupDTO.getGroupName())
                .permissions(permissions)
                .build();
    }

    @Override
    public PermissionGroupDTO transformEntityToDto(PermissionGroupEntity entity) {
        return null;
    }

}
