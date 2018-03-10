package com.rokg.rpc.dubbo.provider.rpc;

import com.alibaba.dubbo.config.annotation.Service;
import com.rokg.rpc.dubbo.api.api.UserService;
import com.rokg.rpc.dubbo.api.data.UserDTO;
import com.rokg.rpc.dubbo.provider.dao.UserDao;
import com.rokg.rpc.dubbo.provider.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午9:01 2018/3/10
 * @Modified By:
 */
@Service(version = "1.0.0")
@Component
public class UserSerivce implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public UserDTO getUserById(Long userId){
        User user = userDao.findOne(userId);
        UserDTO userDTO=new UserDTO();
        BeanUtils.copyProperties(user,userDTO,UserDTO.class);
        return userDTO;
    }
}
