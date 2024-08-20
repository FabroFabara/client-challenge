package com.client.challenge.ec.bs.service.impl;

import com.client.challenge.ec.bs.common.GenericCRUDImpl;
import com.client.challenge.ec.bs.common.GenericRepository;
import com.client.challenge.ec.bs.repository.OrdenArticuloRepository;
import com.client.challenge.ec.bs.service.OrdenArticuloService;
import com.client.challenge.ec.ds.entity.OrdenArticulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenArticuloImpl extends GenericCRUDImpl<OrdenArticulo, Long> implements OrdenArticuloService {

    private final OrdenArticuloRepository ordenArticuloRepository;

    @Autowired
    public OrdenArticuloImpl(OrdenArticuloRepository ordenArticuloRepository) {
        this.ordenArticuloRepository = ordenArticuloRepository;
    }

    @Override
    protected GenericRepository<OrdenArticulo, Long> getClienteRepository() {
        return ordenArticuloRepository;
    }
}
