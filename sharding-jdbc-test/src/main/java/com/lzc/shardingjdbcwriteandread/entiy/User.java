package com.lzc.shardingjdbcwriteandread.entiy;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/28
 * @Description
 */
public class User {
    public String id;
    public String userName;
    public String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
