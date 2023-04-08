package com.stc.boot.service.impl;

import com.stc.boot.dto.GroupDto;
import com.stc.boot.repository.GroupRepository;
import com.stc.boot.service.GroupService;
import com.stc.boot.transform.DtoTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private DtoTransformer groupTransformer;

    public GroupServiceImpl(GroupRepository groupRepository, DtoTransformer groupTransformer) {
        this.groupRepository = groupRepository;
        this.groupTransformer = groupTransformer;
    }

    @Override
    public GroupDto findById(Long id) {
        return groupTransformer.transformGroupFromEntityToDto(groupRepository.findById(id).get());
    }

    @Override
    public GroupDto findByName(String name) {
        return groupTransformer.transformGroupFromEntityToDto(groupRepository.findByName(name).get());
    }

    @Override
    public GroupDto saveGroup(GroupDto groupDto) {
        return groupTransformer.transformGroupFromEntityToDto(groupRepository.save(groupTransformer.transformGroupFromDtoToEntity(groupDto)));
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        GroupDto updatedGroup = findById(groupDto.getId());
        updatedGroup.setName(groupDto.getName());
        return groupTransformer.transformGroupFromEntityToDto(groupRepository.save(groupTransformer.transformGroupFromDtoToEntity(updatedGroup)));
    }

    @Override
    public String deleteGroupById(Long id) {
        GroupDto deletedGroup = findById(id);
        if (deletedGroup == null)
            return "Group Not Found Sucessfully";

        groupRepository.delete(groupTransformer.transformGroupFromDtoToEntity(deletedGroup));
        return "Group Deleted Sucessfully";
    }

    @Override
    public List<GroupDto> findAll() {
        return groupTransformer.transformGroupFromListEntityToDto(groupRepository.findAll());
    }
}
