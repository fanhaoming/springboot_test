package com.springboot.springboot_test.entity;

import com.springboot.springboot_test.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sys_user")
@Data
public class User extends BaseEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @CreatedDate
    @Column
    private Date createTime;

    @CreatedBy
    @Column
    private String creator;

    @CreatedBy
    @Column
    private String updator;

    @CreatedDate
    @Column
    private Date updateTime;

    @Column
    private String username;
}
