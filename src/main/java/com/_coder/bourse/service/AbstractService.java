package com._coder.bourse.service;

import java.util.List;

public interface AbstractService<T> {
    Integer save(T object);

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);

}
