package com.frb.management.repository;

import com.frb.management.model.PlayerDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerDocumentRepository extends JpaRepository<PlayerDocument, Long> {
}
