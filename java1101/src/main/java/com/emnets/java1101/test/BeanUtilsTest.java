package com.emnets.java1101.test;

import com.emnets.java1101.domain.User;
import org.junit.Test;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author lannisite
 * @program BeanUtilsTest
 * @description 描述
 * @date 2022/11/1 23:00
 */

public class BeanUtilsTest {

    @Test
    public void test(){

        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","dyg");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public int[] bestCoordinate(int[][] towers, int radius) {
        int[] result = {0,0};
        int maxq = -1;
        for(int x=0;x<=50;x++){
            for(int y=0;y<=50;y++){
                int qd=0;
                for(int i=0;i< towers.length;i++){
                    int tx = towers[i][0];
                    int ty = towers[i][1];
                    int tq = towers[i][2];
                    double r = radius;
                    double dis = Math.sqrt((tx-x)*(tx-x)+(ty-y)*(ty-y));
                    if(dis>r) continue;
                    qd += tq/(1.0+dis);
                }
                if(qd>maxq){
                    maxq = qd;
                    result[0]=x;
                    result[1]=y;
                }
            }
        }
        return result;
    }






}
