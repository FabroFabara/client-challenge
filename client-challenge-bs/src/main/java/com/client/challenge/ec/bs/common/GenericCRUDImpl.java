package com.client.challenge.ec.bs.common;


import com.client.challenge.ec.bs.exception.ModelNotFoundException;

import java.util.List;
import java.util.Optional;

public abstract class GenericCRUDImpl<T, ID> implements GenericCRUD<T, ID> {

    protected abstract GenericRepository<T, ID> getClienteRepository();

    @Override
    public T save(T t) throws Exception {
        return getClienteRepository().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        getClienteRepository().findById(id).orElseThrow(() -> new ModelNotFoundException(
                String.format("ID  %s NOT FOUND " , id)));
        return getClienteRepository().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return Optional.of(getClienteRepository().findAll()).orElseThrow(() -> new ModelNotFoundException("NO DATA FOUND"));
    }

    @Override
    public T findById(ID id) throws Exception {
        return getClienteRepository().findById(id).orElseThrow(()-> new ModelNotFoundException(
                String.format("ID  %s NOT FOUND " , id)));
    }

    @Override
    public void delete(ID id) throws Exception {
        getClienteRepository().findById(id).orElseThrow(() -> new ModelNotFoundException(
                String.format("ID  %s NOT FOUND " , id)));
        getClienteRepository().deleteById(id);
    }
}
