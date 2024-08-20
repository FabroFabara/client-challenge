package com.client.challenge.ec.bs.service.impl;

import com.client.challenge.ec.bs.common.GenericCRUDImpl;
import com.client.challenge.ec.bs.common.GenericRepository;
import com.client.challenge.ec.bs.repository.OrdenRepository;
import com.client.challenge.ec.bs.service.OrdenService;
import com.client.challenge.ec.ds.entity.Articulo;
import com.client.challenge.ec.ds.entity.Cliente;
import com.client.challenge.ec.ds.entity.Orden;
import com.client.challenge.ec.ds.entity.OrdenArticulo;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class OrdenServiceImpl extends GenericCRUDImpl<Orden, String> implements OrdenService {

    private final OrdenRepository ordenRepository;

    private final ArticuloServiceImpl articuloService;

    private final ClienteServiceImpl clienteService;

    private final OrdenArticuloImpl ordenArticuloService;

    @Autowired
    public OrdenServiceImpl(OrdenRepository ordenRepository, ArticuloServiceImpl articuloService, ClienteServiceImpl clienteService, OrdenArticuloImpl ordenArticuloService) {
        this.ordenRepository = ordenRepository;
        this.articuloService = articuloService;
        this.clienteService = clienteService;
        this.ordenArticuloService = ordenArticuloService;
    }

    @Override
    protected GenericRepository<Orden, String> getClienteRepository() {
        return ordenRepository;
    }

    @Transactional
    @Override
    public Orden save(Orden orden) throws Exception {
        validateData(orden);
        Orden savedOrden = ordenRepository.save(orden);
        almacenarArticulo(savedOrden);
        savedOrden.setArticulos(orden.getArticulos());
        saveTransaction(orden);
        return savedOrden;
    }

    private void validateData(Orden orden) throws Exception {
        if (Objects.isNull(orden.getCliente())) {
            throw new Exception("Cliente no puede ser nulo");
        }
        Cliente cliente = clienteService.findById(orden.getCliente().getIdCliente());
        if (Objects.isNull(cliente)) {
            throw new Exception(String.format("Cliente no encontrado para el id %s",
                    orden.getCliente().getIdCliente()));
        }
        if (Objects.isNull(orden.getArticulos()) || orden.getArticulos().isEmpty()) {
            throw new Exception("Articulos no puede ser nulo o vacio");
        }

        validarCantidadStock(orden);
    }

    private void almacenarArticulo(Orden orden) {
        orden.getArticulos().stream()
                .peek(this::validateArticuloId)
                .map(articulo -> findAndSetOrden(articulo, orden))
                .forEach(this::saveArticulo);
    }

    private void validateArticuloId(Articulo articulo) {
        if (Objects.isNull(articulo.getIdArticulo())) {
            throw new IllegalArgumentException("IdArticulo no puede ser nulo");
        }
    }

    private Articulo findAndSetOrden(Articulo articulo, Orden orden) {
        Articulo foundArticulo = findArticuloById(articulo);
        int newStock = foundArticulo.getStock() - orden.getCantidad();
        foundArticulo.setStock(newStock);
        foundArticulo.setOrden(orden);
        return foundArticulo;
    }

    private Articulo findArticuloById(Articulo articulo) {
        try {
            return articuloService.findById(articulo.getIdArticulo());
        } catch (Exception e) {
            throw new RuntimeException(String.format("Articulo no encontrado para el id %s", articulo.getIdArticulo()), e);
        }
    }

    private void saveArticulo(Articulo articulo) {
        try {

            articuloService.save(articulo);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Error al guardar el articulo con id %s", articulo.getIdArticulo()), e);
        }
    }

    private void validarCantidadStock(Orden orden) throws Exception {
       for (Articulo articulo: orden.getArticulos()){
           Articulo articuloValidar = articuloService.findById(articulo.getIdArticulo());
           if(orden.getCantidad() > articuloValidar.getStock()){
               throw new Exception(String.format(("Error la cantidad enviada %s no puede ser mayor al stock %s"),
                       orden.getCantidad(), articuloValidar.getStock()));
           }
       }
    }

    private void saveTransaction(Orden orden) throws Exception {
        OrdenArticulo ordenArticulo = null;
        for (Articulo articulo: orden.getArticulos()){
            ordenArticulo  = OrdenArticulo.builder()
                    .idOrden(orden.getIdOrden())
                    .idArticulo(articulo.getIdArticulo())
                    .cantidad(orden.getCantidad())
                    .build();
        }
        ordenArticuloService.save(ordenArticulo);
    }
}