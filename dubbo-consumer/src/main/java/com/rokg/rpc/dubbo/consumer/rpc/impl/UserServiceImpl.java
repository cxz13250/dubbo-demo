package com.rokg.rpc.dubbo.consumer.rpc.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.rokg.rpc.dubbo.api.api.UserService;
import com.rokg.rpc.dubbo.api.data.UserDTO;
import org.springframework.stereotype.Component;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:57 2018/3/10
 * @Modified By:
 */
@Component
public class UserServiceImpl implements com.rokg.rpc.dubbo.consumer.rpc.UserService {

    @Reference(version = "1.0.0")
    UserService userService;

    @Override
    public UserDTO findById(Long userId){
        return userService.getUserById(userId);
    }
}
