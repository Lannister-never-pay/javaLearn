package com.emnets.java1123.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author lannisite
 * @program JedisPoolUtils
 * @description Jedis连接池工具类
 * @date 2022/11/23 15:24
 */


/**
 * 加载配置文件，配置连接池的参数
 * 提供获取连接的方法
 */
public class JedisPoolUtils {

    private static JedisPool jedisPool;

    static {
        //  读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(Integer.parseInt(pro.getProperty("maxTotal")));
        config.setMaxIdle(Integer.parseInt(pro.getProperty("maxIdle")));

        //  初始化jedisPool
        jedisPool = new JedisPool(config,pro.getProperty("host"),Integer.parseInt(pro.getProperty("post")));
    }

    /**
     * 获取连接方法
     */
    public static Jedis getJedis(){

        return jedisPool.getResource();
    }

}
