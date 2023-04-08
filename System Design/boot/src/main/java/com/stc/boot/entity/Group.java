package com.stc.boot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "group",fetch = FetchType.LAZY)
    private List<Permission> groupPermissionList;
    @OneToMany(mappedBy = "group",fetch = FetchType.LAZY)
    private List<UserGroup> userGroupList;
}
