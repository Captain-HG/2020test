package com.lzc.shardingjdbcfragmentation.entiy;

import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * @AUTHOR HG-captain
 * @Data 2020/7/22
 * @Description
 */
@TableName("t_order")
public class Order {
    private Long id;

    private String name;

    private String type;

    private Date gmtCreate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
}
