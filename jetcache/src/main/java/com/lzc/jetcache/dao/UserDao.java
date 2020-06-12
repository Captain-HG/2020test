package com.lzc.jetcache.dao;

import com.lzc.jetcache.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @AUTHOR HG-captain
 * @Data 2020/5/7
 * @Description
 */

public interface UserDao {
   @Select(value = "select * from user where id= #{id}")
    User selectUserByUId(@Param("id") String id);
   @Select("select * from user ")
   List<User> selectAllUser ();
}
