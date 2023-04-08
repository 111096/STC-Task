package com.stc.boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionModel {

    private Long id;
    private String name;
    private GroupModel group;
    private Long groupId;

}
