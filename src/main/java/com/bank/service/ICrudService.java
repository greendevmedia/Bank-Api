package com.bank.service;

import java.util.List;

public interface ICrudService<T> {

    List<T> findAll();

    T getOne(Long id);

    void delete(T arg);

    void save(T arg);
    
    void deleteById(Long id);
}
