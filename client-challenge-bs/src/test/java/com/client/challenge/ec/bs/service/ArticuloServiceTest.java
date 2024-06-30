package com.client.challenge.ec.bs.service;

import com.client.challenge.ec.bs.exception.ModelNotFoundException;
import com.client.challenge.ec.bs.repository.ArticuloRepository;
import com.client.challenge.ec.bs.service.impl.ArticuloServiceImpl;
import com.client.challenge.ec.ds.entity.Articulo;
import com.client.challenge.ec.ds.entity.Cliente;
import com.client.challenge.ec.ds.entity.Orden;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArticuloServiceTest {

    @Mock
    private ArticuloRepository articuloRepository;

    @InjectMocks
    private ArticuloServiceImpl articuloServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void save_ShouldSaveArticulo() throws Exception {
        Articulo articulo = Articulo.builder()
                .nombreArticulo("Laptop HP")
                .precioUnitario(100.23)
                .orden(Orden.builder()
                        .idOrden("OC-2301")
                        .fecha(LocalDateTime.now())
                        .cliente(Cliente.builder()
                                .idCliente(1L)
                                .nombre("Juan")
                                .apellido("Perez")
                                .build())
                        .build())
                .build();
        when(articuloRepository.save(any(Articulo.class))).thenReturn(articulo);
        Articulo savedArticulo = articuloServiceImpl.save(articulo);
        assertNotNull(savedArticulo);
        verify(articuloRepository, times(1)).save(articulo);
    }

    @Test
    void findById_ShouldReturnArticulo() throws Exception {
        Long id = 1L;
        Articulo articulo = new Articulo();
        articulo.setIdArticulo(id);

        when(articuloRepository.findById(id)).thenReturn(Optional.of(articulo));

        Articulo foundArticulo = articuloServiceImpl.findById(id);

        assertNotNull(foundArticulo);
        assertEquals(id, foundArticulo.getIdArticulo());
        verify(articuloRepository, times(1)).findById(id);
    }

    @Test
    void findById_ShouldReturnNullWhenNotFound() {
        Long id = 1L;
        assertThrows(ModelNotFoundException.class, () -> articuloServiceImpl.findById(id));
    }

    @Test
    void deleteById_ShouldDeleteArticulo() throws Exception {
        Long id = 1L;
        Articulo articulo = getArticulo(id);
        when(articuloRepository.findById(id)).thenReturn(Optional.ofNullable(articulo));
        assert articulo != null;
        doNothing().when(articuloRepository).deleteById(articulo.getIdArticulo());
        articuloServiceImpl.delete(articulo.getIdArticulo());
        verify(articuloRepository, times(1)).deleteById(id);
    }

    private static Articulo getArticulo(Long id) {
        return Articulo.builder()
                .idArticulo(id)
                .nombreArticulo("Laptop HP")
                .precioUnitario(100.23)
                .orden(Orden.builder()
                        .idOrden("OC-2301")
                        .fecha(LocalDateTime.now())
                        .cliente(Cliente.builder()
                                .idCliente(1L)
                                .nombre("Juan")
                                .apellido("Perez")
                                .build())
                        .build())
                .build();
    }
}