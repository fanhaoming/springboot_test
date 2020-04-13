package com.springboot.springboot_test.repository;

import com.springboot.springboot_test.base.BaseRepository;
import com.springboot.springboot_test.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends BaseRepository<User,String> {

    @Query(value = "SELECT * FROM sys_user WHERE username = ?1",
            countQuery = "SELECT count(*) FROM sys_user WHERE username = ?1",
            nativeQuery = true)
    Page<User> findByUsername(String username, Pageable pageable);


    long count(Specification<User> specification);

    Page<User> findAll(Specification<User> specification, Pageable pageable);

    List<User> findAll(Specification<User> specification);
}
