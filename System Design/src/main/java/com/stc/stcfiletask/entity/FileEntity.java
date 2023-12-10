package com.stc.stcfiletask.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Blob;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "file")
public class FileEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "content", nullable = false, columnDefinition = "bytea")
    private Blob content;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

}

