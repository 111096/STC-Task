package com.stc.stcfiletask.service;

import com.stc.stcfiletask.dto.folderItem.FolderManagementItemRequestDTO;
import com.stc.stcfiletask.dto.folderItem.FolderManagementItemResponseDTO;

public interface FolderService {



    public FolderManagementItemResponseDTO createFolder(FolderManagementItemRequestDTO itemDTO) throws Exception;

}


