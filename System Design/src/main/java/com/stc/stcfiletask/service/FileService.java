package com.stc.stcfiletask.service;

import com.stc.stcfiletask.dto.common.ItemDTO;
import com.stc.stcfiletask.dto.fileItem.FileManagementItemRequestDTO;
import com.stc.stcfiletask.dto.fileItem.FileManagementItemResponseDTO;

public interface FileService {
    public FileManagementItemResponseDTO createFile(FileManagementItemRequestDTO itemDTO) throws Exception;

    public ItemDTO getItemById(Long itemId)throws Exception ;
}


