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
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Guardar Cliente")
    void when_call_save_client_then_return_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/cliente")
                        .content("{\"idCliente\": null, \"nombre\": \"Juan\", \"apellido\": \"Perez\"}")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Perez")))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
    }

    @Test
    @DisplayName("Obtener todos los clientes")
    void when_call_get_all_clients_then_return_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cliente"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Juan")))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
    }

    @Test
    @DisplayName("Obtener cliente por id")
    void when_call_get_client_by_id_then_return_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/cliente/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Juan")))
                .andExpect(MockMvcResultMatchers.header().string("Content-Type", "application/json"));
    }

    @Test
    @DisplayName("Eliminar cliente")
    void when_call_delete_client_then_return_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/cliente/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("eliminado")));
    }
}
