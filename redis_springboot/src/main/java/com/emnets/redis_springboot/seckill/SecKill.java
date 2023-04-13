package com.emnets.redis_springboot.seckill;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Transaction;

import java.io.IOException;
import java.util.List;

/**
 * @create 2023/4/8 15:47
 * @finish
 * @description:
 */
public class SecKill {

    public static void main(String[] args) {
        Jedis jedis = new Jedis();

    }

    public static boolean doSecKill(String uid, String proid) throws IOException {
        //  1.uid和proid判断
        if (uid == null || proid == null) {
            return false;
        }

        // 2.连接jedis,使用连接池，避免超时
        JedisPool jedisPool = new JedisPool();
        Jedis jedis = jedisPool.getResource();

        //  3. 拼接key
        String invenKey = "sk:" + proid + "qt";
        String userKey = "sk:" + proid + "qt";

        //  监视库存
        jedis.watch(invenKey);

        //  4. 判断是否开始
        String inven = jedis.get(invenKey);
        if (inven == null) {
            System.out.println("秒杀尚未开始");
            jedis.close();
            return false;
        }

        //  5.判断是否抢过
        if (jedis.sismember(userKey, uid)) {
            System.out.println("不可重复参与！");
            jedis.close();
            return false;
        }

        //  6.判断库存是否充足
        if (Integer.parseInt(jedis.get(invenKey)) <= 0) {
            System.out.println("秒杀已结束，失败");
            jedis.close();
            return false;
        }

        //  multi事务操作
        Transaction multi = jedis.multi();
        multi.decr(invenKey);
        multi.sadd(userKey, uid);

        List<Object> result = multi.exec();
        if (result == null || result.size() == 0) {
            System.out.println("秒杀失败");
            jedis.close();
            return false;
        }

        System.out.println("秒杀成功");
        jedis.close();
        return true;
    }

}