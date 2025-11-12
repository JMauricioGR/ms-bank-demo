package com.clients.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class ClientControllerTest {

    private static final String BASE_URL = "/api/v1/clientes/";
    Long id = 1L;
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void getClientById() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get(BASE_URL + "getClient/{id}", id)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }
}