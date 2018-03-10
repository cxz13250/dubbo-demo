package com.rokg.rpc.dubbo.api.data;

import java.io.Serializable;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:49 2018/3/10
 * @Modified By:
 */
public class UserDTO implements Serializable {

    private Long id;

    private String name;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
