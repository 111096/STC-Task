package com.stc.stcfiletask.repository;


import com.stc.stcfiletask.entity.PermissionGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionGroupRepository extends JpaRepository<PermissionGroupEntity,Long> {

     Optional<PermissionGroupEntity> findByGroupName(String name);

}
