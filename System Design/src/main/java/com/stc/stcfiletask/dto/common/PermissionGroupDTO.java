package com.stc.stcfiletask.dto.common;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;
@Data
public class PermissionGroupDTO {
    @NotBlank(message = "[Group] name is required.")
    private String groupName;
    @NotBlank(message = "[Group] Permissions level required.")
    private List<PermissionDTO> permissions;

}
