package com.springboot.springboot_test.controls;

import com.springboot.springboot_test.entity.Role;
import com.springboot.springboot_test.entity.User;
import com.springboot.springboot_test.service.RoleService;
import com.springboot.springboot_test.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api(tags = "角色管理相关接口")
@RequestMapping("/role")
@RestController
public class RoleControl {


    @Autowired
    private RoleService roleServiceImpl;

    @ApiOperation("查询角色的接口")
    @GetMapping("/query/{id}")
    public Optional<Role> query(@PathVariable String id) {
        return roleServiceImpl.findById(id);
    }

    @ApiOperation("添加角色的接口")
    @PostMapping("/addUser")
    public Role add(@RequestBody Role role) {
        return roleServiceImpl.save(role);
    }

    @ApiOperation("删除角色的接口")
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        roleServiceImpl.deleteById(id);
    }
}
