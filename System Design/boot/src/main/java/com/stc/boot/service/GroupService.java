package com.stc.boot.service;


import com.stc.boot.dto.GroupDto;

import java.util.List;

public interface GroupService {

    GroupDto findById(Long id);

    GroupDto findByName(String name);

    GroupDto saveGroup(GroupDto groupDto);

    GroupDto updateGroup(GroupDto groupDt);

    String deleteGroupById(Long id);

    List<GroupDto> findAll();



}
