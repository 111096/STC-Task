package com.stc.boot.controller;

import com.stc.boot.dto.PermissionDto;
import com.stc.boot.exception.ResourceNotFoundException;
import com.stc.boot.model.PermissionModel;
import com.stc.boot.service.PermissionService;
import com.stc.boot.transform.ModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    PermissionService permissionService;
    ModelTransformer modelTransformer;

    @Autowired
    PermissionController(PermissionService permissionService, ModelTransformer modelTransformer) {
        this.permissionService = permissionService;
        this.modelTransformer = modelTransformer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PermissionModel> getPermissionById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<PermissionDto> permissionDto = Optional.ofNullable(Optional.ofNullable(permissionService.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("Permission Not Found for this id : " + id)));
        return ResponseEntity.ok(modelTransformer.transformPermissionFromDtoToModel(permissionDto.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<PermissionModel> createPermission(@RequestBody PermissionModel permissionDto) {
        PermissionDto dto = permissionService.savePermission(modelTransformer.transformPermissionFromModelToDto(permissionDto));
        return ResponseEntity.ok(modelTransformer.transformPermissionFromDtoToModel(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<PermissionModel> updatePermission(@RequestBody PermissionModel permissionDto) {
        PermissionDto dto = permissionService.updatePermission(modelTransformer.transformPermissionFromModelToDto(permissionDto));
        return ResponseEntity.ok(modelTransformer.transformPermissionFromDtoToModel(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePermissionById(@PathVariable("id") Long id) {
        String dto = permissionService.deletePermissionById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<PermissionModel>> findAll() {
        List<PermissionModel> dto = modelTransformer.transformPermissionFromListDtoToModel(permissionService.findAll());
        return ResponseEntity.ok(dto);
    }
}
