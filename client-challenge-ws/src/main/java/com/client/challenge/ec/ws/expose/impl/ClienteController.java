package com.client.challenge.ec.ws.expose.impl;


import com.client.challenge.ec.bs.service.impl.ClienteServiceImpl;
import com.client.challenge.ec.bs.utils.GenericConverterUtils;
import com.client.challenge.ec.ds.dto.ClienteDTO;
import com.client.challenge.ec.ds.dto.ClienteRequestDTO;
import com.client.challenge.ec.ds.entity.Cliente;
import com.client.challenge.ec.ws.expose.IClienteController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ClienteController implements IClienteController {

    private final ClienteServiceImpl clienteService;

    private final GenericConverterUtils genericConverterUtils;

    @Autowired
    public ClienteController(ClienteServiceImpl clienteService, GenericConverterUtils genericConverterUtils) {
        this.clienteService = clienteService;
        this.genericConverterUtils = genericConverterUtils;
    }


    @Override
    public ResponseEntity<ClienteRequestDTO> createClient(ClienteRequestDTO clienteRequestDTO) throws Exception {
        Cliente clientResult = clienteService.save(genericConverterUtils.convertToEntity(clienteRequestDTO, Cliente.class));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientResult.getIdCliente()).toUri();
        return ResponseEntity.created(location).body(genericConverterUtils.convertToDto(clientResult, ClienteRequestDTO.class));
    }

    @Override
    public ResponseEntity<ClienteRequestDTO> updateClient(ClienteRequestDTO clienteRequestDTO, Long id) throws Exception {
        Cliente clientResult = clienteService.update(id, genericConverterUtils.convertToEntity(clienteRequestDTO, Cliente.class));
        return ResponseEntity.ok(genericConverterUtils.convertToDto(clientResult, ClienteRequestDTO.class));
    }

    @Override
    public ResponseEntity<ClienteDTO> getClient(Long id) throws Exception {
        return ResponseEntity.ok(genericConverterUtils.convertToDto(clienteService.findById(id), ClienteDTO.class));
    }

    @Override
    public ResponseEntity<List<ClienteDTO>> getAllClients() throws Exception {
        return ResponseEntity.ok(genericConverterUtils.convertListToListDto(clienteService.findAll(), ClienteDTO.class));
    }

    @Override
    public ResponseEntity<String> deleteClient(Long id) throws Exception {
        clienteService.delete(id);
        return ResponseEntity.ok().body(String.format("Cliente con id %s eliminado ",id));
    }
}
