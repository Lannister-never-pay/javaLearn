package com.leetcode;


import com.sun.org.apache.xpath.internal.operations.Bool;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * @program leetcode1110
 * @description 剑指 Offer 04. 二维数组中的查找
 * @date 2022/11/10 22:32
 * @author lannisite
 */

public class leetCode1110 {

    /**
     * 思路：
     * 1.获取到二维数组的n和m
     * 2.h         n
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {



        return true;
    }

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> map= new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
       int[] r =  twoSum(new int[]{3,2,3},6);
        System.out.println(r[0]+":"+r[1]);
    }


}
