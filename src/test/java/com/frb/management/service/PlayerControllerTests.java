package com.frb.management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frb.management.model.Player;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;

@SpringBootTest
public class PlayerControllerTests {

    @Mock
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;
//
//    void createPlayerAllLayers(){
//        Player player = new Player();
//        mockMvc.perform(post("/players/")
//                .contentType(MediaType.APPLICATION_JSON).
//
//                .content(objectMapper.writeValueAsString(user)))
//                .andExpect(status().isOk());
//    }
}
