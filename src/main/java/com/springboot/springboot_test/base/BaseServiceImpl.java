package com.springboot.springboot_test.base;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BaseServiceImpl<T extends BaseEntity,ID> implements BaseService<T,ID> {
    @Autowired
    BaseRepository<T,ID> baseRepository;

    @Override
    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }
}
