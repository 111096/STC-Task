package com.stc.boot.transform;

import com.stc.boot.dto.GroupDto;
import com.stc.boot.dto.PermissionDto;
import com.stc.boot.dto.UserDto;
import com.stc.boot.dto.UserGroupDto;
import com.stc.boot.entity.Group;
import com.stc.boot.entity.Permission;
import com.stc.boot.entity.User;
import com.stc.boot.entity.UserGroup;
import com.stc.boot.service.GroupService;
import com.stc.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DtoTransformer {

    //Group Transformer
    GroupDto groupDto = null;
    Group group = null;

    public GroupDto transformGroupFromEntityToDto(Group group) {
        groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        groupDto.setGroupPermissionList(transformPermissionFromListEntityToDto(group.getGroupPermissionList()));
        groupDto.setUserGroupList(transformUserGroupFromListEntityToDto(group.getUserGroupList()));
        return groupDto;
    }


    public Group transformGroupFromDtoToEntity(GroupDto groupDto) {
        group = new Group();
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        group.setGroupPermissionList(transformPermissionFromListDtoToEntity(groupDto.getGroupPermissionList()));
        group.setUserGroupList(transformUserGroupFromListDtoToEntity(groupDto.getUserGroupList()));
        return group;
    }

    public GroupDto transformGroupFromEntityToDtoOnly(Group group) {
        groupDto = new GroupDto();
        groupDto.setId(group.getId());
        groupDto.setName(group.getName());
        return groupDto;
    }


    public Group transformGroupFromDtoToEntityOnly(GroupDto groupDto) {
        group = new Group();
        group.setId(groupDto.getId());
        group.setName(groupDto.getName());
        return group;
    }

    public List<GroupDto> transformGroupFromListEntityToDto(List<Group> groupList) {
        List<GroupDto> groupDtoList = new ArrayList<>();
        for (Group group : groupList) {
            groupDtoList.add(transformGroupFromEntityToDto(group));
        }
        return groupDtoList;
    }


    public List<Group> transformFromGroupListDtoToEntity(List<GroupDto> groupDtoList) {
        List<Group> groupList = new ArrayList<>();
        for (GroupDto groupDto : groupDtoList) {
            groupList.add(transformGroupFromDtoToEntity(groupDto));
        }
        return groupList;
    }

    //Permission Transformer
    PermissionDto permissionDto = null;
    Permission permission = null;

    public PermissionDto transformPermissionFromEntityToDto(Permission permission) {
        permissionDto = new PermissionDto();
        permissionDto.setId(permission.getId());
        permissionDto.setName(permission.getName());
        permissionDto.setGroup(transformGroupFromEntityToDto(permission.getGroup()));
        return permissionDto;
    }


    public Permission transformPermissionFromDtoToEntity(PermissionDto permissionDto) {
        permission = new Permission();
        permission.setId(permissionDto.getId());
        permission.setName(permissionDto.getName());
        permission.setGroup(transformGroupFromDtoToEntity(permissionDto.getGroup()));
        return permission;
    }

    public PermissionDto transformPermissionFromEntityToDtoOnly(Permission permission) {
        permissionDto = new PermissionDto();
        permissionDto.setId(permission.getId());
        permissionDto.setName(permission.getName());
        return permissionDto;
    }


    public Permission transformPermissionFromDtoToEntityOnly(PermissionDto permissionDto) {
        permission = new Permission();
        permission.setId(permissionDto.getId());
        permission.setName(permissionDto.getName());
        return permission;
    }

    public List<PermissionDto> transformPermissionFromListEntityToDto(List<Permission> permissionList) {
        List<PermissionDto> permissionDtoList = new ArrayList<>();
        for (Permission permission : permissionList) {
            permissionDtoList.add(transformPermissionFromEntityToDtoOnly(permission));
        }
        return permissionDtoList;
    }


    public List<Permission> transformPermissionFromListDtoToEntity(List<PermissionDto> permissionDtoList) {
        List<Permission> permissionList = new ArrayList<>();
        for (PermissionDto permissionDto : permissionDtoList) {
            permissionList.add(transformPermissionFromDtoToEntity(permissionDto));
        }
        return permissionList;
    }

    //User Transformer
    UserDto userDto = null;
    User user = null;

    public UserDto transformUserFromEntityToDto(User user) {
        userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        List<UserGroupDto> userGroupDtoList = transformUserGroupFromListEntityToDto(user.getUserGroupList());
        userDto.setUserGroupDtoList(userGroupDtoList);
        return userDto;
    }


    public User transformUserFromDtoToEntity(UserDto userDto) {
        user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserGroupList(transformUserGroupFromListDtoToEntity(userDto.getUserGroupDtoList()));
        return user;
    }

    public UserDto transformUserFromEntityToDtoOnly(User user) {
        userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setUsername(user.getUsername());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        return userDto;
    }


    public User transformUserFromDtoToEntityOnly(UserDto userDto) {
        user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public List<UserDto> transformUserFromListEntityToDto(List<User> userSet) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User comment : userSet) {
            userDtoList.add(transformUserFromEntityToDto(comment));
        }
        return userDtoList;
    }


    public List<User> transformUserFromListDtoToEntity(List<UserDto> userDtoList) {
        List<User> userList = new ArrayList<>();
        for (UserDto userDto : userDtoList) {
            userList.add(transformUserFromDtoToEntity(userDto));
        }
        return userList;
    }

    //UserGroup Transformer
    UserGroupDto userGroupDto = null;
    UserGroup userGroup = null;

    public UserGroupDto transformUserGroupFromEntityToDto(UserGroup user) {
        userGroupDto = new UserGroupDto();
        userGroupDto.setId(user.getId());
        userGroupDto.setUser(transformUserFromEntityToDtoOnly(user.getUser()));
        userGroupDto.setGroup(transformGroupFromEntityToDtoOnly(user.getGroup()));
        return userGroupDto;
    }

    public UserGroup transformUserGroupFromDtoToEntity(UserGroupDto userGroupDto) {
        userGroup = new UserGroup();
        userGroup.setId(userGroupDto.getId());
        userGroup.setUser(transformUserFromDtoToEntityOnly(userGroupDto.getUser()));
        userGroup.setGroup(transformGroupFromDtoToEntityOnly(userGroupDto.getGroup()));
        return userGroup;
    }


    public List<UserGroup> transformUserGroupFromListDtoToEntity(List<UserGroupDto> userSet) {
        List<UserGroup> userModelList = new ArrayList<>();
        for (UserGroupDto comment : userSet) {
            userModelList.add(transformUserGroupFromDtoToEntity(comment));
        }
        return userModelList;
    }

    public List<UserGroupDto> transformUserGroupFromListEntityToDto(List<UserGroup> userModelList) {
        List<UserGroupDto> userList = new ArrayList<>();
        for (UserGroup userModel : userModelList) {
            userList.add(transformUserGroupFromEntityToDto(userModel));
        }
        return userList;
    }
}
