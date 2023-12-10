package com.stc.stcfiletask.dto.fileItem;

import com.stc.stcfiletask.dto.common.ItemDTO;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class FileManagementItemRequestDTO extends ItemDTO {
    @NotBlank(message = "The item name is required.")
    private String name;
    @Email
    @NotBlank(message = "[User] email is required.")
    private String userEmail;
    @NotNull(message = "Parent id is required.")
    private Long parentId;
    @NotNull(message = "Permission Group  id is required.")
    private Long permissionGroupId;
    @NotBlank(message = "The file content is required.")
    private String fileContent;
}
