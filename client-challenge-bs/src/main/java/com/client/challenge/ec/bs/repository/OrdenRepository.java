package com.client.challenge.ec.bs.repository;

import com.client.challenge.ec.bs.common.GenericRepository;
import com.client.challenge.ec.ds.entity.Orden;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends GenericRepository<Orden, String> {
}
