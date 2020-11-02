package com.frb.management.controller;

import com.frb.management.model.Document;
import com.frb.management.service.DocumentService;
import com.frb.management.service.EntityType;
import com.frb.management.service.ProviderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/documents")
public class DocumentController {

    private DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/{type}/{id}")
    public ResponseEntity<?> saveFiles(@RequestParam("files")MultipartFile []multipartFiles, @PathVariable String type, @PathVariable Long id){
       List<String> fileNames = new ArrayList<>();
        Arrays.asList(multipartFiles)
                .forEach(multipartFile ->{
                        documentService.saveFile(multipartFile, id, EntityType.valueOf(type));
                        fileNames.add(multipartFile.getOriginalFilename());
    });
        return ResponseEntity.status(HttpStatus.OK).body("Files uploaded successfully" + fileNames);
    }

    @PostMapping("")
    public ResponseEntity<?> saveDocumentEntity(@RequestBody Document document, @RequestParam String entityType, @RequestParam Long id){
        System.out.println(EntityType.valueOf(entityType));
        try {
            ProviderInterface save = documentService.save(document, EntityType.valueOf(entityType), id);
            System.out.println(save.provide());
            System.out.println("NIMIC");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
