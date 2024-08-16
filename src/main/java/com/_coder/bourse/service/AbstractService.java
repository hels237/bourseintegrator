package com._coder.bourse.service;

import com._coder.bourse.model.Council;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AbstractService<T> {
    Integer save(T object);

    List<T> findAll();

    T findById(Integer id);

    void delete(Integer id);

}
