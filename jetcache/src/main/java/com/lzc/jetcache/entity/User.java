package com.lzc.jetcache.entity;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Base64;
import java.util.List;

public class User implements Serializable {
    @Id
    private String id;

    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    private static final long serialVersionUID = 1L;







    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }



    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(username);
        sb.append(", password=").append(password);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "<中国信托登记>（）{}[]";
        byte[] bytes = str.getBytes();

        String encode = Base64.getEncoder().encodeToString(bytes);
        System.out.println("加密："+encode);
//        Base64.getDecoder().decode("");
        byte[] decoded = Base64.getDecoder().decode(encode);
        String decodeStr = new String(decoded);
        System.out.println("解密："+decodeStr);
    }
}