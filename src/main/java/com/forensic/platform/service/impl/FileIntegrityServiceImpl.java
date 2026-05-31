package com.forensic.platform.service.impl;

import com.forensic.platform.repository.FileInfoRepository;
import com.forensic.platform.service.FileInfoService;
import com.forensic.platform.service.FileIntegrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileIntegrityServiceImpl implements FileIntegrityService {

    @Autowired
    FileInfoService fileInfoService;

    @Autowired
    FileInfoRepository fileInfoRepository;

    @Override
    public boolean checkIntegrity(String path, String file) {
        String fileHash = fileInfoService.getFileHash(path);
        String existingHash = fileInfoRepository.findByFileName(file);

//        System.out.println(existingHash);

        //validate the existing hash and newhash

        if(fileHash.equals(existingHash)){
            return true;
        }

        return false;
    }
}
