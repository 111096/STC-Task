package com.stc.boot.controller;

import com.stc.boot.dto.GroupDto;
import com.stc.boot.dto.UserDto;
import com.stc.boot.dto.UserGroupDto;
import com.stc.boot.exception.ResourceNotFoundException;
import com.stc.boot.model.UserGroupModel;
import com.stc.boot.service.GroupService;
import com.stc.boot.service.UserGroupService;
import com.stc.boot.service.UserService;
import com.stc.boot.transform.ModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usergroup")
public class UserGroupController {

    UserGroupService userGroupService;
    ModelTransformer modelTransformer;
    UserService userService;
    GroupService groupService;

    @Autowired
    UserGroupController(UserGroupService userGroupService, ModelTransformer modelTransformer, UserService userService, GroupService groupService) {
        this.userGroupService = userGroupService;
        this.modelTransformer = modelTransformer;
        this.userService = userService;
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGroupModel> getUserGroupById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<UserGroupDto> userDto = Optional.ofNullable(Optional.ofNullable(userGroupService.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found for this id : " + id)));
        return ResponseEntity.ok(modelTransformer.transformUserGroupFromDtoToModel(userDto.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<UserGroupModel> createUserGroup(@RequestBody UserGroupModel userGroupDto) {
        UserDto userDto = userService.findById(userGroupDto.getUserModel().getId());
        GroupDto groupDto = groupService.findById(userGroupDto.getGroupModel().getId());
        userGroupDto.setUserModel(modelTransformer.transformUserFromDtoToModel(userDto));
        userGroupDto.setGroupModel(modelTransformer.transformGroupFromDtoToModel(groupDto));
        UserGroupDto dto = userGroupService.saveUser(modelTransformer.transformUserGroupFromModelToDto(userGroupDto));
        return ResponseEntity.ok(modelTransformer.transformUserGroupFromDtoToModel(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<UserGroupModel> updateUserGroup(@RequestBody UserGroupModel userGroupDto) {
        UserGroupDto dto = userGroupService.updateUser(modelTransformer.transformUserGroupFromModelToDto(userGroupDto));
        return ResponseEntity.ok(modelTransformer.transformUserGroupFromDtoToModel(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserGroupById(@PathVariable("id") Long id) {
        String dto = userGroupService.deleteUserById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserGroupModel>> findAll() {
        List<UserGroupModel> dto = modelTransformer.transformUserGroupFromListDtoToModel(userGroupService.findAll());
        return ResponseEntity.ok(dto);
    }
}
