package com.client.challenge.ec.bs.common;

import java.util.List;

public interface GenericCRUD<T, ID> {

    T save(T t) throws Exception;
    T update(ID id, T t) throws Exception;
    List<T> findAll() throws Exception;
    T findById(ID id) throws Exception;
    void delete(ID id) throws Exception;
}
