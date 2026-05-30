package com.forensic.platform.service.impl;

import com.forensic.platform.converter.FileInfoConverter;
import com.forensic.platform.entity.FileInfo;
import com.forensic.platform.model.FileInfoDto;
import com.forensic.platform.repository.FileInfoRepository;
import com.forensic.platform.service.FileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Autowired
    FileInfoRepository fileInfoRepository;

    @Autowired
    FileInfoConverter fileInfoConverter;

    public static String getString(Object obj){
        return String.valueOf(obj);
    }

    @Override
    public FileInfoDto getInfo(String fileName) {

        Path path = Paths.get(fileName);

        try{
            BasicFileAttributes attr = Files.readAttributes(path,
                    BasicFileAttributes.class);

            FileInfo fileInfo = new FileInfo();
            fileInfo.setCtime(getString(attr.creationTime()));
            fileInfo.setMtime(getString(attr.lastModifiedTime()));
            fileInfo.setLtime(getString(attr.lastAccessTime()));
            fileInfo.setSize(attr.size());

            fileInfoRepository.save(fileInfo);

            FileInfoDto fileInfoDto = fileInfoConverter.fileInfoEntityToDto(fileInfo);

            return fileInfoDto;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getFileHash(String path) {
        String fileHash = hashfile(path);
        return fileHash;
    }

    public static String hashfile(String path){

        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            FileInputStream fis = new FileInputStream(path);

            int bytes;

            byte[] buffer = new byte[65536];

            while ((bytes = fis.read(buffer)) != -1){
                messageDigest.update(buffer, 0, bytes);
            }

            fis.close();

            byte[] hexdigest = messageDigest.digest();

            StringBuilder sb = new StringBuilder();

            for(byte b: hexdigest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //for python specific implementation
        /*try{
            ProcessBuilder processBuilder = new ProcessBuilder(
                    "python", "hashfile.py", path
            );

            Process process = processBuilder.start();

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            String line;

            while((line = br.readLine()) != null){
                System.out.println("output from python: "+ line);
            }

            int exitCode = process.waitFor();

            System.out.println("Script Ended with Exitcode: "+ exitCode);

        }catch (Exception e){
            System.out.println("Script Execution Interrupted");
        }

        return null;*/
    }
}
