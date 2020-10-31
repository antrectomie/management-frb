package com.frb.management.service;

import com.frb.management.model.Document;
import com.frb.management.model.Player;
import com.frb.management.model.PlayerDocument;
import com.frb.management.model.TransientWrapper;
import com.frb.management.repository.DocumentRepository;
import com.frb.management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;

@Service
public class DocumentService {
    @Value("${upload.path}")
    private String basePath;

    private final DocumentRepository documentRepository;
    private final PlayerService playerService;
    private final PlayerDocumentService playerDocumentService;


    public DocumentService(DocumentRepository documentRepository, PlayerRepository playerRepository, PlayerService playerService, PlayerDocumentService playerDocumentService) {
        this.documentRepository = documentRepository;
        this.playerService = playerService;
        this.playerDocumentService = playerDocumentService;
    }

    public ProviderInterface save(Document document, EntityType entityType, Long entityId) throws Exception {
        //TransientWrapper<> entity = null;
        ProviderInterface<?> provider = null;
        switch(entityType){
            case PLAYER_TYPE: {
               // entity = new TransientWrapper<PlayerDocument>();
                Player player = playerService.getSimplePlayer(entityId);
                Document savedDoc = documentRepository.save(document);
                PlayerDocument playerDocument = new PlayerDocument();
                playerDocument.setDocument(savedDoc);
                playerDocument.setPlayer(player);
                PlayerDocument savedPlayerDoc = playerDocumentService.save(playerDocument);
                // entity.setEntity(playerDocumentService.save(playerDocument));
                 provider = ()-> savedPlayerDoc;
            }
        }
        return provider;
    }

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

//
//    private void saveDocuments(List<T> documents, Long id){
//        //Player player = playerService.getSimplePlayerById();
//    }

    public  <T> T getEntity(EntityType entityType, Long id){
        switch (entityType){
            case CLUB_TYPE: return (T)playerService.getById(id);


            default: return null;
        }
    }

//    public void updateDocument(MultipartFile multipartFile, EntityType entityType, Long id){
//        if(multipartFile != null && entityType != null) {
//            Document document = new Document();
//            document.setDocumentPath(multipartFile.getOriginalFilename());
//            document.setEmissionDate();
//        }
//
//
//    }




}
