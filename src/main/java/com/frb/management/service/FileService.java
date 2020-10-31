package com.frb.management.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class FileService {

    @Value("${upload.path}")
    private String basePath;

    public void saveFile(MultipartFile multipartFile, Long entityId, EntityType entityType){
        String entityNameForFileCreation = entityType.name().split("_")[0];
        String folderPath = basePath + entityNameForFileCreation + File.separator + entityId;
        Path rootPath = Paths.get(folderPath);
        Path relative = Paths.get( rootPath.toString() + File.separator + multipartFile.getOriginalFilename());
        try {
            Files.createDirectories(rootPath);
            Files.copy(multipartFile.getInputStream(), rootPath.resolve(Objects.requireNonNull(multipartFile.getOriginalFilename())));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rootPath);
    }

}
