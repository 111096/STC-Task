package com.stc.stcfiletask.dto.spaceItem;

import com.stc.stcfiletask.dto.common.PermissionGroupDTO;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class SpaceManagementItemRequestDTO {

    @NotBlank(message = "The item name is required.")
    private String name;
    @NotNull(message = "The permission group is required.")
    private PermissionGroupDTO permissionGroup;
}
