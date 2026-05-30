package com.forensic.platform.repository;

import com.forensic.platform.entity.FileInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends CrudRepository<FileInfo, Long> {
}
