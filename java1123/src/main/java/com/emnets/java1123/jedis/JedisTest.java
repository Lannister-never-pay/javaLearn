package com.emnets.java1123.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author lannisite
 * @program JedisTest
 * @description 描述
 * @date 2022/11/23 11:42
 */

public class JedisTest {


    /**
     * 快速入门
     */
    @Test
    public void test1(){

        //  1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //  2.操作
        jedis.set("name","zhangsan");
        //  3.关闭连接
        jedis.close();
    }

    /**
     * string操作
     */
    @Test
    public void test2(){

        //  1.获取连接
        Jedis jedis = new Jedis();  //  空参数的时候默认local：6379

        //  2.操作
        jedis.set("name","zhangsan");
        String name = jedis.get("name");
        System.out.println(name);

        //  可以使用setex()方法，存储可以指定过期时间的key value
        jedis.setex("activecode",20,"haha");    // 键值对存入redis，20秒后自动删除
        //  3.关闭连接
        jedis.close();
    }

    /**
     *  哈希
     */
    @Test
    public void test3(){

        //  1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //  2.操作
        jedis.hset("user","name","ls");
        jedis.hset("user","age","23");
        jedis.hset("user","gender","male");

        //  获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key :keySet){
            System.out.print(key+":  "+user.get(key)+"  ");
            System.out.println(jedis.hget("user",key));
        }
        System.out.println(user);

        //  3.关闭连接
        jedis.close();
    }


    /**
     * 链表
     */
    @Test
    public void test4(){

        //  1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //  2.操作
        while (jedis.rpop("queue")!=null){
            jedis.rpop("queue");
        }
        jedis.lpush("queue","E","C","A");
        jedis.rpush("queue","M","V","P");
        List<String> queue = jedis.lrange("queue", 0, -1);
        System.out.println(queue);

        //  3.关闭连接
        jedis.close();
    }

    /**
     * 集合
     */
    @Test
    public void test5(){

        //  1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //  2.操作
        jedis.sadd("classmates","a");
        jedis.sadd("classmates","b");

        System.out.println(jedis.smembers("classmates"));

        jedis.zrem("classmates","b");
        System.out.println(jedis.smembers("classmates"));

        //  3.关闭连接
        jedis.close();
    }

    /**
     * 有序链表
     */
    @Test
    public void test6(){

        //  1.获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //  2.操作
        jedis.zadd("set",90,"ys");
        jedis.zadd("set",70,"xsr");

        System.out.println(jedis.zrange("set",0,-1));

        //  3.关闭连接
        jedis.close();
    }

    /**
     * jedis连接池
     */
    @Test
    public void test7(){

        //  0.创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);     //  最大连接数
        config.setMaxIdle(10);      //  空闲连接

        //  1.创建对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //  2.获取连接
        Jedis resource = jedisPool.getResource();

    }

    /**
     * jedis连接池工具类的使用
     */
    @Test
    public void test8(){

        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("hello","world");

        jedis.close();

    }


}
