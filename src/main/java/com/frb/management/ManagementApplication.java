package com.frb.management;

import com.frb.management.model.Player;
import com.frb.management.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
//@EnableJpaAuditing
public class ManagementApplication implements CommandLineRunner {
    @Autowired
    private PlayerRepository playerRepository;
    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Player> all = playerRepository.findAll();
//        all.forEach(System.out::println);
    }
}
