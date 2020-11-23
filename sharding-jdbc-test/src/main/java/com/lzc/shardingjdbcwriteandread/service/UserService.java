package com.lzc.shardingjdbcwriteandread.service;

import com.lzc.shardingjdbcwriteandread.entiy.User;

import java.util.List;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/28
 * @Description
 */
public interface UserService {
    List<User> list();

    Object addUser(User user);
}
