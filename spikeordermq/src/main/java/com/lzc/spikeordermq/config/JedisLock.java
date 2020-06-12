package com.lzc.spikeordermq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

/**
 * @AUTHOR HG-captain
 * @Data 2020/6/11
 * @Description
 */
@Component
public class JedisLock {

    @Autowired
    JedisPool jedisPool;
    /**
     * 加锁
     * @param key
     * @param val
     * @param pxTime key过期时间单位设置为毫秒
     * @return
     */
    public boolean setnx(String key, String val,long pxTime) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            if (jedis == null) {
                return false;
            }
            SetParams params = new SetParams();
            params.nx();
            params.px(pxTime);

            boolean b = jedis.set(key, val,params).
                    equalsIgnoreCase("ok");
            return b;
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 删除锁
     * @param key
     * @param val
     * @return 1为有缓存且删除，0为无数据可删除
     */
    public int delnx(String key, String val) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            if (jedis == null) {
                return 0;
            }
            //if redis.call('get','orderkey')=='1111' then return redis.call('del','orderkey') else return 0 end
            StringBuilder sbScript = new StringBuilder();
            sbScript.append("if redis.call('get','").append(key).append("')").append("=='").append(val).append("'").
                    append(" then ").
                    append("    return redis.call('del','").append(key).append("')").
                    append(" else ").
                    append("    return 0").
                    append(" end");

            return Integer.valueOf(jedis.eval(sbScript.toString()).toString());
        } catch (Exception ex) {
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return 0;
    }

}
