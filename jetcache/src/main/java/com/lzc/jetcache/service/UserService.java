package com.lzc.jetcache.service;

import com.alicp.jetcache.anno.Cached;
import com.lzc.jetcache.entity.User;

import java.util.List;

/**
 * @AUTHOR HG-captain
 * @Data 2020/5/8
 * @Description
 */
public interface UserService {

    @Cached(name="userCache.", key="#id", expire = 3600)
    User selectUserByUId(String id);

    List<User> selectAllUser();
}
