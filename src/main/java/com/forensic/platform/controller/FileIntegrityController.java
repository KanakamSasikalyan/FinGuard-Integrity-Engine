package com.forensic.platform.controller;

import com.forensic.platform.service.FileIntegrityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/integrity")
public class FileIntegrityController {

    @Autowired
    FileIntegrityService fileIntegrityService;

    @GetMapping("/check-integrity")
    public ResponseEntity<String> checkIntegrity(@RequestParam("path") String path, @RequestParam("file") String file){
        boolean fileIntegrity = fileIntegrityService.checkIntegrity(path, file);

        String fileStatus = fileIntegrity ? "FILE SAFE" : "FILE CORRUPTED";

        ResponseEntity<String> fileStatusResponseEntity = new ResponseEntity<>(fileStatus, HttpStatus.OK);
        return fileStatusResponseEntity;
    }

}
