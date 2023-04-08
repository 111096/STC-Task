package com.stc.boot.transform;

import com.stc.boot.dto.GroupDto;
import com.stc.boot.dto.PermissionDto;
import com.stc.boot.dto.UserDto;
import com.stc.boot.dto.UserGroupDto;
import com.stc.boot.model.GroupModel;
import com.stc.boot.model.PermissionModel;
import com.stc.boot.model.UserGroupModel;
import com.stc.boot.model.UserModel;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ModelTransformer {

    PasswordEncoder passwordEncoder;

    public ModelTransformer(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    //Group Transformer
    GroupModel groupModel = null;
    GroupDto group = null;

    public GroupModel transformGroupFromDtoToModel(GroupDto group) {
        groupModel = new GroupModel();
        groupModel.setId(group.getId());
        groupModel.setName(group.getName());

        return groupModel;
    }


    public GroupDto transformGroupFromModelToDto(GroupModel groupModel) {
        group = new GroupDto();
        group.setId(groupModel.getId());
        group.setName(groupModel.getName());
        group.setGroupPermissionList(new ArrayList<>());
        group.setUserGroupList(new ArrayList<>());
        return group;
    }


    public List<GroupModel> transformGroupListFromDtoToModel(List<GroupDto> groupList) {
        List<GroupModel> groupModelList = new ArrayList<>();
        for (GroupDto group : groupList) {
            groupModelList.add(transformGroupFromDtoToModel(group));
        }
        return groupModelList;
    }


    public List<GroupDto> transformGroupListFromModelToDto(List<GroupModel> groupModelList) {
        List<GroupDto> groupList = new ArrayList<>();
        for (GroupModel groupModel : groupModelList) {
            groupList.add(transformGroupFromModelToDto(groupModel));
        }
        return groupList;
    }

    //Permission Transformer
    PermissionModel permissionModel = null;
    PermissionDto permission = null;

    public PermissionModel transformPermissionFromDtoToModel(PermissionDto permission) {
        permissionModel = new PermissionModel();
        permissionModel.setId(permission.getId());
        permissionModel.setName(permission.getName());
        permissionModel.setGroup(transformGroupFromDtoToModel(permission.getGroup()));
        permissionModel.setGroupId(permissionModel.getGroup().getId());
        return permissionModel;
    }


    public PermissionDto transformPermissionFromModelToDto(PermissionModel permissionModel) {
        permission = new PermissionDto();
        permission.setId(permissionModel.getId());
        permission.setName(permissionModel.getName());
        permission.setGroup(transformGroupFromModelToDto(permissionModel.getGroup()));
        return permission;
    }


    public List<PermissionModel> transformPermissionFromListDtoToModel(List<PermissionDto> permissionList) {
        List<PermissionModel> permissionModelList = new ArrayList<>();
        for (PermissionDto permission : permissionList) {
            permissionModelList.add(transformPermissionFromDtoToModel(permission));
        }
        return permissionModelList;
    }


    public List<PermissionDto> transformPermissionFromListModelToDto(List<PermissionModel> permissionModelList) {
        List<PermissionDto> permissionList = new ArrayList<>();
        for (PermissionModel permissionModel : permissionModelList) {
            permissionList.add(transformPermissionFromModelToDto(permissionModel));
        }
        return permissionList;
    }

    //User Transformer
    UserModel userModel = null;
    UserDto user = null;

    public UserModel transformUserFromDtoToModel(UserDto user) {
        userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setName(user.getName());
        userModel.setUsername(user.getUsername());
        userModel.setEmail(user.getEmail());
        userModel.setPassword(passwordEncoder.encode(user.getPassword()));
        return userModel;
    }


    public UserDto transformUserFromModelToDto(UserModel userModel) {
        user = new UserDto();
        user.setId(userModel.getId());
        user.setName(userModel.getName());
        user.setUsername(userModel.getUsername());
        user.setEmail(userModel.getEmail());
        user.setPassword(userModel.getPassword());
        return user;
    }


    public List<UserModel> transformUserFromListDtoToModel(List<UserDto> userSet) {
        List<UserModel> userModelList = new ArrayList<>();
        for (UserDto comment : userSet) {
            userModelList.add(transformUserFromDtoToModel(comment));
        }
        return userModelList;
    }


    public List<UserDto> transformUserFromListModelToDto(List<UserModel> userModelList) {
        List<UserDto> userList = new ArrayList<>();
        for (UserModel userModel : userModelList) {
            userList.add(transformUserFromModelToDto(userModel));
        }
        return userList;
    }

    //UserGroup Transformer
    UserGroupModel userGroupModel = null;
    UserGroupDto userGroup = null;

    public UserGroupModel transformUserGroupFromDtoToModel(UserGroupDto user) {
        userGroupModel = new UserGroupModel();
        userGroupModel.setId(user.getId());
        userGroupModel.setUserModel(transformUserFromDtoToModel(user.getUser()));
        userGroupModel.setGroupModel(transformGroupFromDtoToModel(user.getGroup()));
        return userGroupModel;
    }


    public UserGroupDto transformUserGroupFromModelToDto(UserGroupModel userGroupModel) {
        userGroup = new UserGroupDto();
        userGroup.setId(userGroupModel.getId());
        userGroup.setUser(transformUserFromModelToDto(userGroupModel.getUserModel()));
        userGroup.setGroup(transformGroupFromModelToDto(userGroupModel.getGroupModel()));
        return userGroup;
    }


    public List<UserGroupModel> transformUserGroupFromListDtoToModel(List<UserGroupDto> userSet) {
        List<UserGroupModel> userModelList = new ArrayList<>();
        for (UserGroupDto dto : userSet) {
            userModelList.add(transformUserGroupFromDtoToModel(dto));
        }
        return userModelList;
    }


    public List<UserGroupDto> transformUserGroupFromListModelToDto(List<UserGroupModel> userModelList) {
        List<UserGroupDto> userList = new ArrayList<>();
        for (UserGroupModel userModel : userModelList) {
            userList.add(transformUserGroupFromModelToDto(userModel));
        }
        return userList;
    }
}
