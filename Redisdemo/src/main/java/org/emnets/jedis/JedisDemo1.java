package org.emnets.jedis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @create 2023/4/6 16:58
 * @finish
 * @description:
 */
public class JedisDemo1 {

    private final static Jedis jedis = new Jedis("127.0.0.1",6379);

    public static void main(String[] args) {
        //  创建jedis对象
        Jedis jedis = new Jedis("127.0.0.1",6379);
        //  测试
        System.out.println(jedis.ping());
    }

    @Before
    public void init(){
        System.out.println("Redis init..."+jedis.ping());
    }

    //String  操作key
    @Test
    public void TestString(){

        //  添加数据
        jedis.set("name","parzival");

        //  获取
        String name = jedis.get("name");
        System.out.println("name:"+name);

        //  mset
        jedis.mset("k1","v1","k2","v2");
        String[] strings = {"k1", "k2", "name"};
        //  可以单独入参
        jedis.mget("k1","k2","name");
        //  也可以输入string
        System.out.println(jedis.mget(strings));


        Set<String> keys = jedis.keys("*");
        for(String key: keys){
            System.out.println(key);
        }
    }


    //  测试List
    @Test
    public void TestList(){

        jedis.lpush("key1","lucy","mary","jack");
        List<String> key1 = jedis.lrange("key1", 0, -1);
        System.out.println(key1);

    }

    //  测试set
    @Test
    public void TestSet(){
        jedis.sadd("sname","lucy","mary","jack");
        Set<String> name = jedis.smembers("sname");
        System.out.println(name);
    }

    //  测试hash
    @Test
    public void TestHash(){
        //  直接添加
        jedis.hset("users","age","20");

        //  使用map添加
        Map<String,String> mp = new HashMap();
        mp.put("id","10086");
        jedis.hset("users",mp);

        Set<String> hkeys = jedis.hkeys("users");
        System.out.println(hkeys);
    }

    //  测试zset
    @Test
    public void TestZset(){
        //  直接添加
        jedis.zadd("china",100d,"beijing");

        //  map添加
        Map<String,Double> mp = new HashMap<>();
        mp.put("hangzhou",600d);
        mp.put("shanghai",200d);
        mp.put("shenzhen",300d);
        jedis.zadd("china",mp);

        Set<String> china = jedis.zrange("china", 0, -1);
        System.out.println(china);
    }

    @After
    public void close(){
        jedis.close();
    }

}