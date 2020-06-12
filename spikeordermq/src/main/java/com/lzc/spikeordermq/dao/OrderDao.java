package com.lzc.spikeordermq.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Map;


/**
 * @AUTHOR HG-captain
 * @Data 2020/6/12
 * @Description
 */
public interface OrderDao {

    void insertOrderRecord(Map map);

}
