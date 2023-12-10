package com.stc.stcfiletask.entity;

import com.stc.stcfiletask.dto.common.PermissionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "permission")
@NoArgsConstructor
public class PermissionEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "permission_level")
    private String permissionLevel;

    @ManyToOne(fetch = FetchType.LAZY, cascade =CascadeType.ALL)
    @JoinColumn(name = "group_id")
    private PermissionGroupEntity group;

    // Getters and setters

    public PermissionEntity(PermissionDTO permissionDTO) {
        super();
        this.userEmail=permissionDTO.getUserEmail();
        this.permissionLevel=permissionDTO.getPermissionLevel();
    }
}

