package com.springboot.springboot_test.entity;

import com.springboot.springboot_test.base.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "sys_role")
@Data
public class Role extends BaseEntity {
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    @Column
    private String name;

}
