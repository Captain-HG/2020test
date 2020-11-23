package com.lzc.shardingjdbcwriteandread.dao;

import com.lzc.shardingjdbcwriteandread.entiy.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/28
 * @Description
 */
@Mapper
public interface UserDao {
    @Select(value = "select * from user")
    List<User> list();

    void add(User user);
}
