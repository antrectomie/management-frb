package com.frb.management.repository;

import com.frb.management.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;


@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findBySportClubId(Long clubId);

}
