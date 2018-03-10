package com.rokg.rpc.dubbo.provider.model;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:57 2018/3/10
 * @Modified By:
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;
}
