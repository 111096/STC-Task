package com.stc.stcfiletask.controller;

import com.stc.stcfiletask.dto.common.APIResponse;
import com.stc.stcfiletask.dto.spaceItem.SpaceManagementItemRequestDTO;
import com.stc.stcfiletask.service.APIResponseService;
import com.stc.stcfiletask.service.SpaceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/items/space")
public class SpaceManagementController {
    @Autowired
    private SpaceService spaceService;
    @Autowired
    private APIResponseService apiResponseService;

    @PostMapping("/create")
    public ResponseEntity<?> createSpace(@Valid @RequestBody SpaceManagementItemRequestDTO itemDTO) throws Exception {

        APIResponse apiResponse = apiResponseService.generateServiceResponse(HttpStatus.OK.toString(),
                "Space created Successfully!", spaceService.createSpace(itemDTO));
        return ResponseEntity.ok(apiResponse);

    }

}
