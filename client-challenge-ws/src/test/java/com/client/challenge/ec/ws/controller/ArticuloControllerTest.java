package com.client.challenge.ec.ws.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ArticuloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Guardar Articulo")
    void when_call_save_article_then_return_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/articulo")
                        .content("{\"idArticulo\": null, \"nombreArticulo\": \"Laptop HP\", \"precioUnitario\": 100.23}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Laptop")))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
    }
}
