package com.frb.management.service;

import com.frb.management.errorconfig.ExceptionType;
import com.frb.management.exceptions.WrongIdException;
import com.frb.management.model.Contact;
import com.frb.management.model.Player;
import com.frb.management.repository.ContactRepository;
import com.frb.management.repository.PlayerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class PlayerServiceTest {

    @Autowired
    private PlayerService playerService;
    @MockBean
    private PlayerRepository playerRepository;
    @MockBean
    private AddressService addressService;
    @MockBean
    ContactRepository contactRepository;

    @TestConfiguration
    static class TestConfigFriendships {
        @Bean
        public PlayerService friendshipService(PlayerRepository playerRepository,
                                               AddressService addressService, ContactRepository contactRepository) {
            return new PlayerService(playerRepository,addressService, contactRepository);
        }
    }

    @Test
    public void testGetPlayerByIdTest_whenPlayerExistsInDb_expectPlayer(){
        Player player = new Player();
        player.setId(1L);
        player.setCnp("123243252");
        player.setFirstName("popa");
//        System.out.println(playerService.getById(1L));
        given(playerRepository.findById(player.getId())).willReturn(Optional.of(player));
        Assertions.assertEquals(playerService.getById(1L).getId(), 1);
    }

    @Test
    public void testGetUser_whenIdIsNull_throwsException(){
        //when(playerRepository.findById(null)).thenThrow(new RuntimeException());
        Assertions.assertThrows(WrongIdException.class, () -> playerService.getById(null));
    }


    @Test
    public void testGetAllPlayers_whenPlayerExistsInDb_expectAllPlayers(){
        given(playerRepository.findAll()).willReturn(createPlayers());
        Assertions.assertEquals(playerService.getPlayers().size(), 3);
    }

    @Test
    public void givenPlayerIdNull_expectedThrowWrongIdException(){
        Runnable runnable  = () -> playerService.getById(null);
        assertThrowType(ExceptionType.PLAYER_TYPE, runnable);
    }

    @Test
    public void givenPlayerIdThatNotExists_expectedThrowEntityNotFoundException(){
        assertThrows(EntityNotFoundException.class, () -> playerService.getById(-1L));
    }

    @Test
    public void testsSavePlayer_whenPlayerNotNull_expectFetchSavedPlayer(){
        Player player = new Player();
        Contact contact = new Contact();
        contact.setAddresses(new ArrayList<>());
        player.setContact(contact);
        player.setId(1L);
        when(playerRepository.save(any(Player.class))).thenReturn(player);
        Player savedUser = playerService.save(player);
        assertEquals(savedUser.getId(),player.getId());
    }

    //@Test
    //nu ar trebui sa treaca testul daca nu am null la argument la save
    public void testSavePlayer_whenPlayerIsNull_ExpectToThrowNPE(){
        when(playerRepository.save(any(Player.class))).thenReturn(new Player());
        Player player = new Player();
        player.setId(1L);
        assertThrows(NullPointerException.class, () -> playerService.save(player));
    }



    public void assertThrowType(ExceptionType exceptionType, Runnable runnable){
        try{
            runnable.run();
            fail();
        }catch(WrongIdException ex){
            assertEquals(exceptionType, ex.getExceptionType());
        }
    }

    public static List<Player> createPlayers(){
        Player player = new Player();
        player.setId(1L);
        player.setFirstName("george");
        player.setLastName("calin");
        player.setCnp("123456");
        player.setBirthNationality("roman");
        player.setDateOfBirth(LocalDate.now());
        player.setCurrentNationality("roman");
        player.setPathOfPicture("aaa/bbb/ccc");
        player.setContact(null);

        Player player2 = new Player();
        player.setId(1L);
        player.setFirstName("vasco");
        player.setLastName("mirel");
        player.setCnp("555");
        player.setBirthNationality("roman");
        player.setDateOfBirth(LocalDate.now());
        player.setCurrentNationality("roman");
        player.setPathOfPicture("aaa/bbb/ccc");
        player.setContact(null);


        Player player3 = new Player();
        player.setId(1L);
        player.setFirstName("hagi");
        player.setLastName("gheorghe");
        player.setCnp("8888888");
        player.setBirthNationality("roman");
        player.setDateOfBirth(LocalDate.now());
        player.setCurrentNationality("roman");
        player.setPathOfPicture("aaa/bbb/ccc");
        player.setContact(null);

        return Arrays.asList(player, player2, player3);
    }


    private static Player createPlayer() {
        Player player = new Player();
        player.setId(1L);
        player.setFirstName("hagi");
        player.setLastName("gheorghe");
        player.setCnp("8888888");
        player.setBirthNationality("roman");
        player.setDateOfBirth(LocalDate.now());
        player.setCurrentNationality("roman");
        player.setPathOfPicture("aaa/bbb/ccc");
        player.setContact(null);
        return player;
    }
}
