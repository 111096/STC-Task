package com.stc.stcfiletask.service.impl;

import com.stc.stcfiletask.dto.spaceItem.SpaceManagementItemRequestDTO;
import com.stc.stcfiletask.dto.spaceItem.SpaceManagementItemResponseDTO;
import com.stc.stcfiletask.entity.ItemEntity;
import com.stc.stcfiletask.repository.ItemRepository;
import com.stc.stcfiletask.service.SpaceService;
import com.stc.stcfiletask.transformer.impl.ItemTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpaceServiceImpl implements SpaceService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemTransformer itemTransformer;


    @Override
    public SpaceManagementItemResponseDTO createSpace(SpaceManagementItemRequestDTO spaceManagementItemRequestDTO) {
        ItemEntity spaceEntity = itemRepository.save(itemTransformer.transformSpaceItemDtoToEntityWithPermissions(spaceManagementItemRequestDTO));
        return new SpaceManagementItemResponseDTO(spaceEntity.getId(), spaceEntity.getPermissionGroupEntity().getId());
    }


}

