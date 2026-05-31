package com.forensic.platform.converter;

import com.forensic.platform.entity.FileInfo;
import com.forensic.platform.model.FileInfoDto;
import org.springframework.stereotype.Component;

@Component
public class FileInfoConverter {

    public FileInfoDto fileInfoEntityToDto(FileInfo fileInfo){

        FileInfoDto fileInfoDto = new FileInfoDto();
        fileInfoDto.setCtime(fileInfo.getCtime());
        fileInfoDto.setMtime(fileInfo.getMtime());
        fileInfoDto.setLtime(fileInfo.getLtime());
        fileInfoDto.setSize(fileInfo.getSize());

        return fileInfoDto;

    }
}
