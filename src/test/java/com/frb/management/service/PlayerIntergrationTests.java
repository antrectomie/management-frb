package com.frb.management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frb.management.model.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.http.server.reactive.MockServerHttpRequest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerIntergrationTests {

    @Mock
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void createPlayer(){
        Player player = new Player();
        mockMvc.perform(MockServerHttpRequest.post("/players/")
                .contentType(MediaType.APPLICATION_JSON)
                org.springframework.test.web.servlet.result.MockMvcResultMatchers.content()
                .accept(MediaType.APPLICATION_JSON)
                .andExpect(status().isOk());
        mockMvc.perform(post("").contentType(MediaType.APPLICATION_JSON).body())
    }
}
