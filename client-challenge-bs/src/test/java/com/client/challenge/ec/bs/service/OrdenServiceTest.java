package com.client.challenge.ec.bs.service;

import com.client.challenge.ec.bs.repository.OrdenRepository;
import com.client.challenge.ec.bs.service.impl.ArticuloServiceImpl;
import com.client.challenge.ec.bs.service.impl.ClienteServiceImpl;
import com.client.challenge.ec.bs.service.impl.OrdenServiceImpl;
import com.client.challenge.ec.ds.entity.Articulo;
import com.client.challenge.ec.ds.entity.Cliente;
import com.client.challenge.ec.ds.entity.Orden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrdenServiceTest {

    @Mock
    private OrdenRepository ordenRepository;

    @Mock
    private ArticuloServiceImpl articuloService;

    @Mock
    private ClienteServiceImpl clienteService;

    @InjectMocks
    private OrdenServiceImpl ordenServiceImpl;

    private Orden orden;
    private Cliente cliente;
    private Articulo articulo;

    @BeforeEach
    void setUp() {
        cliente = Cliente.builder()
                .idCliente(1L)
                .nombre("Juan")
                .apellido("Perez")
                .build();

        articulo = Articulo.builder()
                .idArticulo(1L)
                .nombreArticulo("Laptop HP")
                .precioUnitario(100.23)
                .build();

        orden = Orden.builder()
                .idOrden("OC-2301")
                .fecha(LocalDateTime.now())
                .cliente(cliente)
                .articulos(Collections.singletonList(articulo))
                .build();
    }

    @Test
    void testSaveOrdenSuccess() throws Exception {
        when(clienteService.findById(1L)).thenReturn(cliente);
        when(ordenRepository.save(any(Orden.class))).thenReturn(orden);
        when(articuloService.findById(1L)).thenReturn(articulo);

        Orden savedOrden = ordenServiceImpl.save(orden);

        assertNotNull(savedOrden);
        assertEquals(orden.getCliente(), savedOrden.getCliente());
        verify(ordenRepository, times(1)).save(orden);
        verify(articuloService, times(1)).save(articulo);
    }

    @Test
    void testSaveOrdenClienteNotFound() throws Exception {
        when(clienteService.findById(1L)).thenReturn(null);

        Exception exception = assertThrows(Exception.class, () -> ordenServiceImpl.save(orden));
        assertEquals("Cliente no encontrado para el id 1", exception.getMessage());
        verify(ordenRepository, times(0)).save(any(Orden.class));
    }

    @Test
    void testSaveOrdenWithNullCliente() {
        orden.setCliente(null);
        Exception exception = assertThrows(Exception.class, () -> ordenServiceImpl.save(orden));
        assertEquals("Cliente no puede ser nulo", exception.getMessage());
        verify(ordenRepository, times(0)).save(any(Orden.class));
    }
}