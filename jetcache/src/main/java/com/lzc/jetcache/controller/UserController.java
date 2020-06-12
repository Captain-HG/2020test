package com.lzc.jetcache.controller;

import com.lzc.jetcache.entity.User;
import com.lzc.jetcache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @AUTHOR HG-captain
 * @Data 2020/5/8
 * @Description
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/selectUserByUId/{id}")
    @ResponseBody
    public User selectUserByUId(@PathVariable("id") String id){
        User user = userService.selectUserByUId(id);

        return user;
    }

    @RequestMapping(value = "test01" )
    @ResponseBody
    public String test01(){
       return "mmp";
    }
}
