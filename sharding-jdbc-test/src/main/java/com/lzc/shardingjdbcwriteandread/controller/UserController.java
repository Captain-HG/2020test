package com.lzc.shardingjdbcwriteandread.controller;

import com.lzc.shardingjdbcwriteandread.entiy.User;
import com.lzc.shardingjdbcwriteandread.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/28
 * @Description
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object list() {
        return userService.list();
    }

    @GetMapping("/add")
    public Object add(@RequestParam String id, @RequestParam String username, @RequestParam String  password) {
        User user = new User();
        user.setId(id);
        user.setUserName(username);
        user.setPassword(password);
        return userService.addUser(user);
    }
}