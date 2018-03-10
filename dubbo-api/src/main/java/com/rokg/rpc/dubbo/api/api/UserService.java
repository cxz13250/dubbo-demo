package com.rokg.rpc.dubbo.api.api;

import com.rokg.rpc.dubbo.api.data.UserDTO;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:58 2018/3/10
 * @Modified By:
 */
public interface UserService {

    UserDTO getUserById(Long userId);
}
