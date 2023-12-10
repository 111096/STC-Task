package com.stc.stcfiletask.dto.common;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PermissionDTO {
    @NotBlank(message = "The permission level is required.")
    private String permissionLevel;
    @NotBlank(message = "The user Email is required.")
    private String  userEmail;

}
