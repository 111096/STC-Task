package com.stc.stcfiletask.repository;


import com.stc.stcfiletask.entity.FileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity,Long> {

    @Modifying
    @Query(value = "insert into file (content,item_id) VALUES (:content,:item_id)", nativeQuery = true)
    @Transactional
    void saveFile(@Param("content") byte[] content, @Param("item_id") Long item_id);

}
