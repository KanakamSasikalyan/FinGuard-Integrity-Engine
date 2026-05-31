package com.forensic.platform.service;

import com.forensic.platform.model.FileInfoDto;

public interface FileInfoService {
    public FileInfoDto getInfo(String path, String file);
    public String getFileHash(String path);
}
