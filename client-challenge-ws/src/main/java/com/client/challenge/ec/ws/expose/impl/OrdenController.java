package com.client.challenge.ec.ws.expose.impl;

import com.client.challenge.ec.bs.service.impl.OrdenServiceImpl;
import com.client.challenge.ec.bs.utils.GenericConverterUtils;
import com.client.challenge.ec.ds.dto.OrdenDTO;
import com.client.challenge.ec.ds.dto.OrdenRequestDTO;
import com.client.challenge.ec.ds.entity.Orden;
import com.client.challenge.ec.ws.expose.IOrdenController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class OrdenController implements IOrdenController {

    private final OrdenServiceImpl ordenService;

    private final GenericConverterUtils genericConverterUtils;

    @Autowired
    public OrdenController(OrdenServiceImpl ordenService, GenericConverterUtils genericConverterUtils) {
        this.ordenService = ordenService;
        this.genericConverterUtils = genericConverterUtils;
    }


    @Override
    public ResponseEntity<OrdenDTO> createOrder(OrdenRequestDTO ordenRequestDTO) throws Exception {
        Orden orderResult = ordenService.save(genericConverterUtils.convertToEntity(ordenRequestDTO, Orden.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(orderResult.getIdOrden()).toUri();
        return ResponseEntity.created(location).body(genericConverterUtils.convertToDto(orderResult, OrdenDTO.class));
    }

    @Override
    public ResponseEntity<OrdenDTO> updateOrder(OrdenDTO ordenDTO, String id) throws Exception {
        Orden orderResult = ordenService.update(id, genericConverterUtils.convertToEntity(ordenDTO, Orden.class));
        return ResponseEntity.ok(genericConverterUtils.convertToDto(orderResult, OrdenDTO.class));
    }

    @Override
    public ResponseEntity<OrdenDTO> getOrder(String id) throws Exception {
        return ResponseEntity.ok(genericConverterUtils.convertToDto(ordenService.findById(id), OrdenDTO.class));
    }

    @Override
    public ResponseEntity<List<OrdenDTO>> getAllOrder() throws Exception {
        return ResponseEntity.ok(genericConverterUtils.convertListToListDto(ordenService.findAll(), OrdenDTO.class));
    }

    @Override
    public ResponseEntity<Void> deleteOrder(String id) throws Exception {
        ordenService.delete(id);
        return ResponseEntity.ok().build();
    }
}
