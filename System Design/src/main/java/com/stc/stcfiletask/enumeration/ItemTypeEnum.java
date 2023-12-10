package com.stc.stcfiletask.enumeration;

import lombok.Getter;


@Getter
public enum ItemTypeEnum {
    SPACE("SPACE"),
    FOLDER("FOLDER"),
    FILE("FILE");


    private final String value;

    ItemTypeEnum(String value) {
        this.value = value;
    }

    public static ItemTypeEnum fromId(String id) {
        for (ItemTypeEnum at : ItemTypeEnum.values()) {
            if (at.getValue().equalsIgnoreCase(id)) {
                return at;
            }
        }
        return null;
    }
}
