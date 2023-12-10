package com.stc.stcfiletask.dto.spaceItem;

import lombok.Data;

@Data
public class SpaceManagementItemResponseDTO {

    private Long spaceId;
    private Long spacePermissionGroupId;


    public SpaceManagementItemResponseDTO(Long spaceId, Long spacePermissionGroupId) {

        this.spaceId=spaceId;
        this.spacePermissionGroupId=spacePermissionGroupId;
    }
}
