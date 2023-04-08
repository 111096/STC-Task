package com.stc.boot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupModel {

    private Long id;
    private UserModel userModel;
    private GroupModel groupModel;
}
