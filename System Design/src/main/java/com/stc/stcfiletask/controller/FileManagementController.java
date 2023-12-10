package com.stc.stcfiletask.controller;

import com.stc.stcfiletask.dto.common.APIResponse;
import com.stc.stcfiletask.dto.fileItem.FileManagementItemRequestDTO;
import com.stc.stcfiletask.service.APIResponseService;
import com.stc.stcfiletask.service.FileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items/file")
public class FileManagementController {
    @Autowired
    private FileService fileService;
    @Autowired
    APIResponseService apiResponseService;

    @PostMapping("/create")
    public ResponseEntity<?> createFile(@Valid @RequestBody FileManagementItemRequestDTO itemDTO) throws Exception {

        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.OK.toString(),
                "File created Successfully!",
                 fileService.createFile(itemDTO));
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/viewMetadata")
    public ResponseEntity<?> viewFileMetadata(@RequestParam Long itemId) {
        return ResponseEntity.ok("File metadata.");
    }
}



