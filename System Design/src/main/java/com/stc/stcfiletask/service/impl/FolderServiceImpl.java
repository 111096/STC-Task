package com.stc.stcfiletask.service.impl;

import com.stc.stcfiletask.dto.folderItem.FolderManagementItemRequestDTO;
import com.stc.stcfiletask.dto.folderItem.FolderManagementItemResponseDTO;
import com.stc.stcfiletask.entity.ItemEntity;
import com.stc.stcfiletask.entity.PermissionGroupEntity;
import com.stc.stcfiletask.enumeration.PermissionEnum;
import com.stc.stcfiletask.exception.ParentItemNotFoundException;
import com.stc.stcfiletask.exception.UserNotAuthorizedException;
import com.stc.stcfiletask.repository.ItemRepository;
import com.stc.stcfiletask.repository.PermissionGroupRepository;
import com.stc.stcfiletask.repository.PermissionRepository;
import com.stc.stcfiletask.service.FolderService;
import com.stc.stcfiletask.service.UserAuthorityService;
import com.stc.stcfiletask.transformer.impl.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FolderServiceImpl implements FolderService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    PermissionGroupRepository permissionGroupRepository;
    @Autowired
    private PermissionRepository permissionRepository;
    @Autowired
    private ItemTransformer itemTransformer;
    @Autowired
    private UserAuthorityService userAuthorityService;

    @Override
    public FolderManagementItemResponseDTO createFolder(FolderManagementItemRequestDTO folderManagementItemRequestDTO) throws Exception {
        if (userAuthorityService.checkIfUserAuthorized(folderManagementItemRequestDTO.getUserEmail(), PermissionEnum.EDIT, folderManagementItemRequestDTO.getPermissionGroupId())) {
            Optional<ItemEntity> parent = itemRepository.findById(folderManagementItemRequestDTO.getParentId());
            if (parent.isPresent()) {
                ItemEntity itemEntity = itemTransformer.transformFolderItemDtoToEntity(folderManagementItemRequestDTO);
                PermissionGroupEntity permissionGroupEntity = permissionGroupRepository.findById(folderManagementItemRequestDTO.getPermissionGroupId()).get();
                itemEntity.setPermissionGroupEntity(permissionGroupEntity);
                itemEntity.setParentId(parent.get());
                return new FolderManagementItemResponseDTO(itemEntity.getId(), itemEntity.getPermissionGroupEntity().getId());
            } else {
                throw new ParentItemNotFoundException("The Parent of the Item Not Found!");
            }
        } else {
            throw new UserNotAuthorizedException("User is not authorized!");
        }
    }

}
