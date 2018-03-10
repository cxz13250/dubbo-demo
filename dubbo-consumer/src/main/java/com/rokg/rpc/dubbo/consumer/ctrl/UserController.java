package com.rokg.rpc.dubbo.consumer.ctrl;

import com.rokg.rpc.dubbo.api.data.UserDTO;
import com.rokg.rpc.dubbo.consumer.rpc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:56 2018/3/10
 * @Modified By:
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "api/user",method = RequestMethod.GET)
    public UserDTO getUser(@RequestParam(value = "userId")Long userId){
        try {
            UserDTO dto=userService.findById(userId);
            System.out.println(dto.getEmail());
            return dto;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
