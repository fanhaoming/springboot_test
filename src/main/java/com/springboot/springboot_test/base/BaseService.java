package com.springboot.springboot_test.base;

import java.util.List;
import java.util.Optional;

public interface BaseService<T extends BaseEntity,ID> {
    void deleteById(ID id);

    T save(T t);

    List<T> findAll();

    Optional<T> findById(ID id);
}
