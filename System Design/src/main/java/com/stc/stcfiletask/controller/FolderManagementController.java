package com.stc.stcfiletask.controller;

import com.stc.stcfiletask.dto.common.APIResponse;
import com.stc.stcfiletask.dto.folderItem.FolderManagementItemRequestDTO;
import com.stc.stcfiletask.service.APIResponseService;
import com.stc.stcfiletask.service.FolderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items/folder")
public class FolderManagementController {
    @Autowired
    private FolderService folderService;
    @Autowired
    private APIResponseService apiResponseService;

    @PostMapping("/create")
    public ResponseEntity<?> createFolder(@Valid @RequestBody FolderManagementItemRequestDTO folderManagementItemRequestDTO) throws Exception {
        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.OK.toString(),
                "Folder created Successfully!",
                folderService.createFolder(folderManagementItemRequestDTO));
        return ResponseEntity.ok(apiResponse);
    }

}
