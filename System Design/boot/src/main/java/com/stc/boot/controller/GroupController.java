package com.stc.boot.controller;

import com.stc.boot.dto.GroupDto;
import com.stc.boot.entity.Group;
import com.stc.boot.exception.ResourceNotFoundException;
import com.stc.boot.model.GroupModel;
import com.stc.boot.service.GroupService;
import com.stc.boot.transform.ModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class GroupController {

    GroupService groupService;
    ModelTransformer modelTransformer;

    @Autowired
    GroupController(GroupService groupService, ModelTransformer modelTransformer) {
        this.groupService = groupService;
        this.modelTransformer = modelTransformer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupModel> getGroupById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<GroupDto> groupDto = Optional.ofNullable(Optional.ofNullable(groupService.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("Group Not Found for this id : " + id)));
        return ResponseEntity.ok(modelTransformer.transformGroupFromDtoToModel(groupDto.get()));
    }

    @PreAuthorize("hasRole('Main')")
    @PostMapping("/create")
    public ResponseEntity<GroupDto> createGroup(@RequestBody GroupModel groupDto) {
        GroupDto dto = groupService.saveGroup(modelTransformer.transformGroupFromModelToDto(groupDto));
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<GroupDto> updateGroup(@RequestBody GroupModel groupDto) {
        GroupDto dto = groupService.updateGroup(modelTransformer.transformGroupFromModelToDto(groupDto));
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteGroupById(@PathVariable("id") Long id) {
        String dto = groupService.deleteGroupById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<GroupModel>> findAll() {
        List<GroupModel> dto = modelTransformer.transformGroupListFromDtoToModel(groupService.findAll());
        return ResponseEntity.ok(dto);
    }
}
