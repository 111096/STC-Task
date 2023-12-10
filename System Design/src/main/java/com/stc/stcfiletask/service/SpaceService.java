package com.stc.stcfiletask.service;

import com.stc.stcfiletask.dto.spaceItem.SpaceManagementItemRequestDTO;
import com.stc.stcfiletask.dto.spaceItem.SpaceManagementItemResponseDTO;

public interface SpaceService {

    public SpaceManagementItemResponseDTO createSpace(SpaceManagementItemRequestDTO itemDTO) throws Exception ;

}


