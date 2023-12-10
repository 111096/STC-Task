package com.stc.stcfiletask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permission_group")
@Builder
public class PermissionGroupEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "group", cascade =CascadeType.ALL)
    private List<PermissionEntity> permissions;

}
