package com.stc.stcfiletask.dto.fileItem;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FileManagementItemResponseDTO {
    private String fileId;

    public FileManagementItemResponseDTO(String fileId) {
        this.fileId = fileId;
    }
}
