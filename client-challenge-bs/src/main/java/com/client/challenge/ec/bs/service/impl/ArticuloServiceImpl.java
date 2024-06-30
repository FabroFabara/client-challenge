package com.client.challenge.ec.bs.service.impl;

import com.client.challenge.ec.bs.common.GenericCRUDImpl;
import com.client.challenge.ec.bs.common.GenericRepository;
import com.client.challenge.ec.bs.repository.ArticuloRepository;
import com.client.challenge.ec.bs.service.ArticuloService;
import com.client.challenge.ec.ds.entity.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl extends GenericCRUDImpl<Articulo, Long> implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    @Autowired
    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    protected GenericRepository<Articulo, Long> getClienteRepository() {
        return articuloRepository;
    }
}
