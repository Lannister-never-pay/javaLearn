package com.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author lannisite
 * @program leetCode1813
 * @description 描述
 * @date 2023/1/16 21:32
 */

public class leetCode1813 {


    public String[] sToWords(String s){
        return s.split(" ");
    }

    public boolean areSentencesSimilar(String sentence1, String sentence2) {

        if(sentence1.equals(sentence2)){
            return true;
        }

        String[] s1 = sToWords(sentence1.length()>sentence2.length()?sentence1:sentence2);
        String[] s2 = sToWords(sentence1.length()<sentence2.length()?sentence1:sentence2);

        int i = 0;
        int j = s2.length-1;
        for(;i<s2.length;i++){
            if(!s1[i].equals(s2[i])){
                break;
            }
        }
        i--;
        for(int k=s1.length-1;j>i&&k>=0;j--,k--){
            if(!s1[k].equals(s2[j])){
                break;
            }
        }
        j++;
        return j==i+1;
    }

        @Test
        public void Test(){
            System.out.println(areSentencesSimilar("c h p Ny","c BDQ r h p Ny"));
        }
    }


