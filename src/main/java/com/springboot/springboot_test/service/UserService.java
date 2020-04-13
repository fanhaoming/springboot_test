package com.springboot.springboot_test.service;

import com.springboot.springboot_test.base.BaseService;
import com.springboot.springboot_test.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService extends BaseService<User,String> {
    Page<User> findByUsername(String username);

    List<User> queryUserByPage(int pageNo, int pageSize, User user);
}
