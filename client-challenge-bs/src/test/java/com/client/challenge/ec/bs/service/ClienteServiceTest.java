package com.client.challenge.ec.bs.service;


import com.client.challenge.ec.bs.exception.ModelNotFoundException;
import com.client.challenge.ec.bs.repository.ClienteRepository;
import com.client.challenge.ec.bs.service.impl.ClienteServiceImpl;
import com.client.challenge.ec.ds.entity.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteServiceImpl clienteServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void when_calls_save_success() throws Exception {
        Cliente cliente = Cliente.builder()
                .nombre("Juan")
                .apellido("Perez")
                .build();
        when(clienteRepository.saveAndFlush(any(Cliente.class))).thenReturn(cliente);

        Cliente savedCliente = clienteServiceImpl.save(cliente);

        assertNotNull(savedCliente);
        verify(clienteRepository, times(1)).saveAndFlush(cliente);
    }

    @Test
    void when_calls_update_success() throws Exception {
        Long id = 1L;
        Cliente existingCliente = new Cliente();
        existingCliente.setIdCliente(id);
        Cliente updatedCliente = new Cliente();

        when(clienteRepository.findById(id)).thenReturn(Optional.of(existingCliente));
        when(clienteRepository.saveAndFlush(any(Cliente.class))).thenReturn(existingCliente);

        Cliente result = clienteServiceImpl.update(id, updatedCliente);

        assertNotNull(result);
        verify(clienteRepository, times(1)).findById(id);
        verify(clienteRepository, times(1)).saveAndFlush(existingCliente);
    }

    @Test
    void when_calls_update_throwsExceptions() {
        Long id = 1L;
        Cliente updatedCliente = new Cliente();

        when(clienteRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ModelNotFoundException.class, () -> clienteServiceImpl.update(id, updatedCliente));
        verify(clienteRepository, times(1)).findById(id);
        verify(clienteRepository, never()).saveAndFlush(any(Cliente.class));
    }
}
