package com.stc.stcfiletask.enumeration;

import lombok.Getter;


@Getter
public enum PermissionEnum {
    VIEW("VIEW"),
    EDIT("EDIT"),
    DELETE("DELETE");


    private final String value;

    PermissionEnum(String value) {
        this.value = value;
    }

    public static PermissionEnum fromId(String id) {
        for (PermissionEnum at : PermissionEnum.values()) {
            if (at.getValue().equalsIgnoreCase(id)) {
                return at;
            }
        }
        return null;
    }
}
