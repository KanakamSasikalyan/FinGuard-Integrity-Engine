package com.forensic.platform.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FileInfoDto {
    private String filename;
    private String ctime;
    private String mtime;
    private String ltime;
    private Long size;
    private String fileHash;
}
