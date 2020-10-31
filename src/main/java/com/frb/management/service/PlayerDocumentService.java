package com.frb.management.service;

import com.frb.management.exceptions.WrongIdException;
import com.frb.management.exceptions.WrongParameterException;
import com.frb.management.model.Document;
import com.frb.management.model.Player;
import com.frb.management.model.PlayerDocument;
import com.frb.management.repository.PlayerDocumentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class PlayerDocumentService {
    private PlayerDocumentRepository playerDocumentRepository;

    public PlayerDocumentService(PlayerDocumentRepository playerDocumentRepository) {
        this.playerDocumentRepository = playerDocumentRepository;
    }

    public PlayerDocument save(PlayerDocument playerDocument){
        if(playerDocument == null){throw new WrongParameterException("PlayerDocument is null");
        }
        Player player = playerDocument.getPlayer();
        Document document = playerDocument.getDocument();
        return playerDocumentRepository.save(playerDocument);
    }
}
