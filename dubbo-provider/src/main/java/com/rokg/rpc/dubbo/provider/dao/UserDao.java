package com.rokg.rpc.dubbo.provider.dao;

import com.rokg.rpc.dubbo.provider.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Author ROKG
 * @Description
 * @Date: Created in 下午8:57 2018/3/10
 * @Modified By:
 */
public interface UserDao extends CrudRepository<User, Long> {
}
