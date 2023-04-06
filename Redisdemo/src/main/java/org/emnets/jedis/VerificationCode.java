package org.emnets.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * @create 2023/4/6 17:34
 * @finish
 * @description:
 */
public class VerificationCode {


    private final static String phoneNum = "1591234567";
    private final static String countKey = "VerifyCode" + phoneNum + ":count";
    private final static String codeKey = "VerifyCode" + phoneNum + ":code";
    private final static Jedis jedis = new Jedis("127.0.0.1", 6379);

    public static void main(String[] args) {
        System.out.println(getCode());
        //verifyCode(phoneNum);
        getRedisCode(phoneNum, "");
    }

    @Test
    public void SendCode() {
        verifyCode(phoneNum);
        System.out.println("验证码：" + jedis.get(codeKey));
    }

    @Test
    public void testCode() {
        getRedisCode(phoneNum, "968009");
    }


    @Test
    public void testKeys() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.keys("*"));
        System.out.println("验证码：" + jedis.get(codeKey));
        jedis.close();
    }


    //  获取验证码
    public static String getCode() {
        return Integer.toString((int) (Math.random() * 1000000));
    }

    //  发送验证码
    public static void verifyCode(String phoneNum) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);


        String count = jedis.get(countKey);
        if (count == null) {
            //  取不到值，说明第一次，设置为1
            jedis.setex(countKey, 24 * 60 * 60, "1");
        } else if (Integer.parseInt(count) <= 2) {
            jedis.incr(countKey);
        } else if (Integer.parseInt(count) > 2) {
            System.out.println("今天验证码次数用完");
            jedis.close();
            return;
        }

        //  把验证码存入redis
        String vcode = getCode();
        jedis.setex(codeKey, 120, vcode);
        jedis.close();
    }


    //  验证码校验
    public static void getRedisCode(String phoneNum, String code) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        String redisCode = jedis.get(codeKey);

        if (redisCode.equals(code)) {
            System.out.println("success!");
        } else {
            System.out.println("fail");
        }
        jedis.close();
    }


}