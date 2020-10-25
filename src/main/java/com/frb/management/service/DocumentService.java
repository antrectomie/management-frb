package com.frb.management.service;

import com.frb.management.exceptions.MethodNotImplementedYet;
import com.frb.management.model.Document;
import com.frb.management.repository.DocumentRepository;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
    private DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    private Document save(Document document){
        throw new MethodNotImplementedYet("Metoda nu este inca implementata");
    }
}
