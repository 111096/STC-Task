package com.stc.stcfiletask.transformer.impl;

import com.stc.stcfiletask.dto.common.ItemDTO;
import com.stc.stcfiletask.dto.fileItem.FileManagementItemRequestDTO;
import com.stc.stcfiletask.dto.folderItem.FolderManagementItemRequestDTO;
import com.stc.stcfiletask.dto.spaceItem.SpaceManagementItemRequestDTO;
import com.stc.stcfiletask.entity.ItemEntity;
import com.stc.stcfiletask.enumeration.ItemTypeEnum;
import com.stc.stcfiletask.transformer.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemTransformer implements Transformer<ItemEntity, ItemDTO> {

    @Autowired
    private PermissionGroupTransformer permissionGroupTransformer;

    @Override
    public ItemEntity transformDtoToEntity(ItemDTO itemDTO) {
        return ItemEntity.builder()
                .name(itemDTO.getType())
                .type(ItemTypeEnum.fromId(itemDTO.getType()))
                .build();
    }

    @Override
    public ItemDTO transformEntityToDto(ItemEntity entity) {
        return null;
    }


    public ItemEntity transformSpaceItemDtoToEntityWithPermissions(SpaceManagementItemRequestDTO spaceManagementItemRequestDTO) {
//
        return ItemEntity.builder()
                .name(spaceManagementItemRequestDTO.getName())
                .type(ItemTypeEnum.SPACE).
                permissionGroupEntity(permissionGroupTransformer.transformDtoToEntity(spaceManagementItemRequestDTO.getPermissionGroup()))
                .build();

    }

    public ItemEntity transformFolderItemDtoToEntity(FolderManagementItemRequestDTO itemDTO) {
        return ItemEntity.builder()
                .name(itemDTO.getName())
                .type(ItemTypeEnum.FOLDER)
                .build();
    }

    public ItemEntity transformFileItemDtoToEntity(FileManagementItemRequestDTO fileManagementItemRequestDTO) {
        return ItemEntity.builder()
                .name(fileManagementItemRequestDTO.getType())
                .type(ItemTypeEnum.FILE)
//                .parentId(fileItemRequestDTO.getParentId())
                .build();
    }
}
