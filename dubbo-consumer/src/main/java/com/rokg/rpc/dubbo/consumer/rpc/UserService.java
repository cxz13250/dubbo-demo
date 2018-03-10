package com.rokg.rpc.dubbo.consumer.rpc;

import com.rokg.rpc.dubbo.api.data.UserDTO;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午9:15 2018/3/10
 * @Modified By:
 */
public interface UserService {

    UserDTO findById(Long userId);
}
