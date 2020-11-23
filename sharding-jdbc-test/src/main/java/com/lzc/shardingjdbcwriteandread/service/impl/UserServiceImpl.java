package com.lzc.shardingjdbcwriteandread.service.impl;

import com.lzc.shardingjdbcwriteandread.dao.UserDao;
import com.lzc.shardingjdbcwriteandread.entiy.User;
import com.lzc.shardingjdbcwriteandread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/28
 * @Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> list() {
        return userDao.list();
    }

    @Override
    public Object addUser(User user) {
        userDao.add(user);
        return "mmp";
    }
}
