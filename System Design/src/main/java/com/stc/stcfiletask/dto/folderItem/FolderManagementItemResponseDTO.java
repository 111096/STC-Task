package com.stc.stcfiletask.dto.folderItem;

import lombok.Data;

@Data
public class FolderManagementItemResponseDTO {

    private Long folderId;
    private Long folderPermissionGroupId;


    public FolderManagementItemResponseDTO(Long folderId, Long folderPermissionGroupId) {

        this.folderId=folderId;
        this.folderPermissionGroupId=folderPermissionGroupId;
    }
}
