package com.lzc.jetcache.service.impl;

import com.lzc.jetcache.dao.UserDao;
import com.lzc.jetcache.entity.User;
import com.lzc.jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR HG-captain
 * @Data 2020/5/8
 * @Description
 */
@Service(value = "UserService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User selectUserByUId(String id) {
        return userDao.selectUserByUId(id);
    }

    @Override
    public List<User> selectAllUser() {
        return userDao.selectAllUser();
    }
}
