package com.stc.stcfiletask.service.impl;

import com.stc.stcfiletask.dto.common.ItemDTO;
import com.stc.stcfiletask.dto.fileItem.FileManagementItemRequestDTO;
import com.stc.stcfiletask.dto.fileItem.FileManagementItemResponseDTO;
import com.stc.stcfiletask.entity.ItemEntity;
import com.stc.stcfiletask.entity.PermissionEntity;
import com.stc.stcfiletask.enumeration.PermissionEnum;
import com.stc.stcfiletask.exception.UserNotAuthorizedException;
import com.stc.stcfiletask.repository.FileRepository;
import com.stc.stcfiletask.repository.ItemRepository;
import com.stc.stcfiletask.repository.PermissionRepository;
import com.stc.stcfiletask.service.FileService;
import com.stc.stcfiletask.transformer.impl.ItemTransformer;
import com.stc.stcfiletask.util.DataParser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FileServiceImpl implements FileService {

    @Autowired

    private ItemRepository itemRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private FileRepository fileRepository;
    @Autowired
    private ItemTransformer itemTransformer;
    @Autowired
    private EntityManager entityManager;
    @Override
    public FileManagementItemResponseDTO createFile(FileManagementItemRequestDTO fileManagementItemRequestDTO) {
        Optional<PermissionEntity> permissionEntity = permissionRepository.findByUserEmailAndPermissionLevel(fileManagementItemRequestDTO.getUserEmail(), PermissionEnum.EDIT.getValue());
        if (permissionEntity.isPresent()) {
            ItemEntity itemEntity = itemTransformer.transformFileItemDtoToEntity(fileManagementItemRequestDTO);
            ItemEntity save = itemRepository.save(itemEntity);
            fileRepository.saveFile(DataParser.convertBase64ToBytes(fileManagementItemRequestDTO.getFileContent()), save.getId());
            return new FileManagementItemResponseDTO("File ID !!!!");

        } else {
            throw new UserNotAuthorizedException("User is not authorized!");
        }
    }

    @Override
    public ItemDTO getItemById(Long itemId) {
        return null;
    }


//
private void saveFileNative(byte[] fileData, Long itemId) {
    try {
        String sql = "INSERT INTO file (content, item_id) VALUES (?, ?)";
        Query query = entityManager.createNativeQuery(sql);
        query.setParameter(1, fileData);
        query.setParameter(2, itemId);
        query.executeUpdate();
    } catch (Exception e) {
        // Handle exceptions
    }}
 }
