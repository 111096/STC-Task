package com.stc.stcfiletask.entity;

import com.stc.stcfiletask.enumeration.ItemTypeEnum;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "item")
public class ItemEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ItemTypeEnum type;

    @Column(name = "name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "permission_group_id")
    private PermissionGroupEntity permissionGroupEntity;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ItemEntity parentId;

}

