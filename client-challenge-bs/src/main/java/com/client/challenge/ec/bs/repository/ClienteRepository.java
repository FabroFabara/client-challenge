package com.client.challenge.ec.bs.repository;

import com.client.challenge.ec.bs.common.GenericRepository;
import com.client.challenge.ec.ds.entity.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository  extends GenericRepository<Cliente, Long> {
}
