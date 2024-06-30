package com.client.challenge.ec.bs.service.impl;

import com.client.challenge.ec.bs.common.GenericCRUDImpl;
import com.client.challenge.ec.bs.common.GenericRepository;
import com.client.challenge.ec.bs.exception.ModelNotFoundException;
import com.client.challenge.ec.bs.repository.ClienteRepository;
import com.client.challenge.ec.bs.service.ClienteService;
import com.client.challenge.ec.ds.entity.Cliente;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ClienteServiceImpl extends GenericCRUDImpl<Cliente, Long> implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    protected GenericRepository<Cliente, Long> getClienteRepository() {
        return clienteRepository;
    }

    @Transactional
    @Override
    public Cliente save(Cliente cliente) throws Exception {
        return clienteRepository.saveAndFlush(cliente);
    }

    @Transactional
    @Override
    public Cliente update(Long id, Cliente cliente) throws Exception {
        Cliente clienteToUpdate = clienteRepository.findById(id).orElseThrow(() -> new ModelNotFoundException("ID NOT FOUND: " + id));
        BeanUtils.copyProperties(cliente, clienteToUpdate, "idCliente");
        return clienteRepository.saveAndFlush(clienteToUpdate);
    }
}
