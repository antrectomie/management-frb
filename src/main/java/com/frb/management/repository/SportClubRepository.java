package com.frb.management.repository;

import com.frb.management.model.SportClub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SportClubRepository extends JpaRepository<SportClub, Long> {
    List<SportClub> findByLigueId(Long id);
}
