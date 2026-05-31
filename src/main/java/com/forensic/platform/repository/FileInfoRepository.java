package com.forensic.platform.repository;

import com.forensic.platform.entity.FileInfo;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends CrudRepository<FileInfo, Long> {

    @Query(value = "SELECT file_hash FROM FILE_INFO WHERE filename = :file", nativeQuery = true)
    public String findByFileName(String file);

}
