package com.forensic.platform.controller;

import com.forensic.platform.model.FileInfoDto;
import com.forensic.platform.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/file")
public class FileInfoController {

    @Autowired
    FileInfoService fileInfoService;

    @GetMapping("/info")
    public ResponseEntity<FileInfoDto> getInfo(@RequestParam("path") String path){
        FileInfoDto fileInfoDto = fileInfoService.getInfo(path);

        ResponseEntity<FileInfoDto> fileInfoDtoResponseEntity = new ResponseEntity<>(fileInfoDto, HttpStatus.OK);
        return fileInfoDtoResponseEntity;
    }

    @GetMapping("/get-file-hash")
    public ResponseEntity<String> getFileHash(@RequestParam("path") String path){
        String fileHash = fileInfoService.getFileHash(path);
        ResponseEntity<String> fileHashResponseEntity = new ResponseEntity<>(fileHash, HttpStatus.OK);
        return fileHashResponseEntity;
    }
}
