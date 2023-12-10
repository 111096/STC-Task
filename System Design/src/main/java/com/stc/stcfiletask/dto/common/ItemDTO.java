package com.stc.stcfiletask.dto.common;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public abstract class ItemDTO {
    @NotBlank(message = "The item type is required.")
    private String type;

}
