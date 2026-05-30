package com.forensic.platform.service;

import com.forensic.platform.model.FileInfoDto;

public interface FileInfoService {
    public FileInfoDto getInfo(String path);
    public String getFileHash(String path);
}
