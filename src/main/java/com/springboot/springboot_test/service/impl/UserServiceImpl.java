package com.springboot.springboot_test.service.impl;


import com.springboot.springboot_test.base.BaseServiceImpl;
import com.springboot.springboot_test.entity.User;
import com.springboot.springboot_test.repository.UserRepository;
import com.springboot.springboot_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,String> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> findByUsername(String username) {
        return userRepository.findByUsername(username, PageRequest.of(1,10));
    }

    @Override
    public List<User> queryUserByPage(int pageNo, int pageSize, User user) {
        List<User> result = null;

        // 构造自定义查询条件
        Specification<User> queryCondition = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
              if (user.getId() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("id"), user.getId()));
                }
                if (user.getUsername() != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("username"), user.getUsername()));
                }
                /*  if (createTimeStart != null && createTimeEnd != null) {
                    predicateList.add(criteriaBuilder.between(root.get("createTime"), createTimeStart, createTimeEnd));
                }*/
                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };

        // 分页和不分页，这里按起始页和每页展示条数为0时默认为不分页，分页的话按创建时间降序
        try {
            if (pageNo == 0 && pageSize == 0) {
                result = userRepository.findAll(queryCondition);
            } else {
                result = userRepository.findAll(queryCondition, PageRequest.of(pageNo - 1, pageSize, Sort.by(Sort.Direction.DESC, "createTime"))).getContent();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
