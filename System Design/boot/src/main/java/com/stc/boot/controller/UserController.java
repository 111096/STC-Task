package com.stc.boot.controller;

import com.stc.boot.dto.UserDto;
import com.stc.boot.exception.ResourceNotFoundException;
import com.stc.boot.model.UserModel;
import com.stc.boot.service.UserService;
import com.stc.boot.transform.ModelTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserService userService;
    ModelTransformer modelTransformer;

    @Autowired
    UserController(UserService userService, ModelTransformer modelTransformer) {
        this.userService = userService;
        this.modelTransformer = modelTransformer;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        Optional<UserDto> userDto = Optional.ofNullable(Optional.ofNullable(userService.findById(id))
                .orElseThrow(() -> new ResourceNotFoundException("User Not Found for this id : " + id)));
        return ResponseEntity.ok(modelTransformer.transformUserFromDtoToModel(userDto.get()));
    }

    @PostMapping("/create")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userDto) {
        UserDto dto = userService.saveUser(modelTransformer.transformUserFromModelToDto(userDto));
        return ResponseEntity.ok(modelTransformer.transformUserFromDtoToModel(dto));
    }

    @PutMapping("/update")
    public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userDto) {
        UserDto dto = userService.updateUser(modelTransformer.transformUserFromModelToDto(userDto));
        return ResponseEntity.ok(modelTransformer.transformUserFromDtoToModel(dto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") Long id) {
        String dto = userService.deleteUserById(id);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> findAll() {
        List<UserModel> dto = modelTransformer.transformUserFromListDtoToModel(userService.findAll());
        return ResponseEntity.ok(dto);
    }
}
