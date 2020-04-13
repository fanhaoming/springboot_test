package com.springboot.springboot_test.controls;

import com.springboot.springboot_test.entity.User;
import com.springboot.springboot_test.repository.UserRepository;
import com.springboot.springboot_test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@Api(tags = "用户管理相关接口")
@RequestMapping("/user")
@RestController
public class UserControl {


    @Autowired
    private UserService userServiceImpl;

    @ApiOperation("查询用户的接口")
    @GetMapping("/query/{id}")
    public Optional<User> query(@PathVariable String id) {
        return userServiceImpl.findById(id);
    }

    @ApiOperation("添加用户的接口")
    @PostMapping("/addUser")
    public User add(@RequestBody User user) {
        return userServiceImpl.save(user);
    }
    @ApiOperation("分页查询用户的接口")
    @PostMapping("/page")
    public List<User> findByPage(@RequestBody User user) {
        return userServiceImpl.queryUserByPage(1,10,user);
    }

    @ApiOperation("删除用户的接口")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        userServiceImpl.deleteById(id);
    }
}
