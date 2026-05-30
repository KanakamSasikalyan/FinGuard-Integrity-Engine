package com.forensic.platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "file_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ctime;
    private String mtime;
    private String ltime;
    private Long size;
    private String fileHash;
}
