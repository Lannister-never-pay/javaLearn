package com.leetcode;

import sun.misc.Queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lannisite
 * @program leetcode1117
 * @description 描述
 * @date 2022/11/17 20:54
 */

public class leetcode1117 {

    public static int numMatchingSubseq(String s, String[] words) {
        int count =0 ;
        Map<String,Integer>map = new HashMap<>();
        Queue<Integer> queue = new Queue<>();


        for(int i=0;i<words.length;i++){

            if(map.containsKey(words[i])){
                count+=map.get(words[i]);
                continue;
            }
            if(s.indexOf(words[i])!=-1){
                count++;
                map.put(words[i],1);
            }else {
                String temp = words[i];
                int it = 0;
                for(int j=0;j<s.length();j++){
                    if(it<temp.length()&&s.charAt(j)==temp.charAt(it)){
                        it++;
                    }
                }
                if(it==temp.length()){
                    count++;
                    map.put(temp,1);
                }else{
                    map.put(temp,0);
                }
            }
        }
        return count;
    }
    



    public static void main(String[] args) {
        //String s = "dsahjpjauf";
        //System.out.println(s.indexOf("wahjpjau"));
        numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"});
    }


}
